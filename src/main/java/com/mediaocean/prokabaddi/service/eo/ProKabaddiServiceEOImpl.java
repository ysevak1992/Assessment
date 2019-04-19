package com.mediaocean.prokabaddi.service.eo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.mediaocean.prokabaddi.domain.Team;
import com.mediaocean.prokabaddi.vo.Match;

@Service
public class ProKabaddiServiceEOImpl  implements ProKabaddiServiceEO{
	
private static final Logger LOGGER = LoggerFactory.getLogger(ProKabaddiServiceEOImpl.class);
	
	private List<Match> initializeMatches(List<Team> teams) {
		// Define matches to be return
		List<Match> matches = new ArrayList<Match>();

		// Initialize matches
		for (Team teamA : teams) {
			for (Team teamB : teams) {
				if (teamA.getId() != teamB.getId()) {
					Match match = new Match(teamA, teamB);
					match.setLocation(teamA.getCity());
					
					matches.add(match);
				}
			}
		}

		// Return list of matches
		return matches;
	}
	
	private boolean isMatchScheduleRemaining(List<Match> matches) {
		for (Match match : matches) {
			if (match.getDate() == null) {
				return true;
			}
		}
		return false;
	}
	
	private List<Integer> prepareParticipatedTeamList(List<Match> matches, Date date) {
		List<Integer> teamIds = new ArrayList<Integer>();
		for (Match match : matches) {
			if (match.getDate() != null) {
				if (date.equals(match.getDate())) {
					teamIds.add(match.getTeamA().getId());
					teamIds.add(match.getTeamB().getId());
				}
			}
		}
		return teamIds;
	}
	
	@Override
	public List<Match> generate(List<Team> teams, Date startDate) {
		// Generate matches from combination of teams
		List<Match> matches = initializeMatches(teams);
		

		// Define current date
		DateTime currentDate = new DateTime(startDate.getTime());
		
		// Loop till one of the match date has not been scheduled
		while (isMatchScheduleRemaining(matches)) {
			
			// Prepare already participated team id list
			List<Integer> participatedTeamIds = prepareParticipatedTeamList(matches, currentDate.minus(Period.days(1)).toDate());

			// Swap object in list 
			Random random = new Random();
			Collections.swap(matches, random.nextInt(matches.size()), random.nextInt(matches.size()));
			
			for (Match match : matches) {
				if (match.getDate() == null &&
						!participatedTeamIds.contains(match.getTeamA().getId()) &&
						!participatedTeamIds.contains(match.getTeamB().getId())) {
					match.setDate(currentDate.toDate());
					participatedTeamIds.add(match.getTeamA().getId());
					participatedTeamIds.add(match.getTeamB().getId());
				}
			}
			
			// Increment current date by 2 days
			currentDate = currentDate.plus(Period.days(1));
		}
		printMatches(matches);
		return matches;
	}
	
	public void printMatches(List<Match> matches) {
		LOGGER.debug( formatString("TEAM-A"), formatString("TEAM-B"), formatString("Location"), formatString("Date"));
		System.out.println( formatString("TEAM-A")+""+ formatString("TEAM-B")+""+formatString("Location")+""+ formatString("Date"));
		LOGGER.debug(" --------------------------------------------------------------------------------------------------------------------------------------------");
		for (Match match : matches) {
			System.out.println(""+ formatString(match.getTeamA().getName())+""+ formatString(match.getTeamB().getName())+""+ formatString(match.getLocation())+""+ formatString(formatDate(match.getDate())));
			LOGGER.debug( formatString(match.getTeamA().getName()), formatString(match.getTeamB().getName()), formatString(match.getLocation()), formatString(formatDate(match.getDate())));
		}
	}
	private static String formatDate(Date actualDate) {
		return new SimpleDateFormat("dd-MM-yyyy").format(actualDate);
	}
	
	private static String formatString(String actualString) {
		return StringUtils.rightPad(actualString, 20, "");
	}
}
