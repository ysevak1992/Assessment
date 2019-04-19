package com.mediaocean.prokabaddi.service.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mediaocean.prokabaddi.domain.Team;
import com.mediaocean.prokabaddi.repository.TeamRepository;
import com.mediaocean.prokabaddi.service.eo.ProKabaddiServiceEO;
import com.mediaocean.prokabaddi.vo.Match;

@Service
public class ProKabaddiServiceBOImpl implements ProKabaddiServiceBO {
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	ProKabaddiServiceEO matchScheduler;
	
	
	@Override
	public List<Match> matchScheduler(String teamIds, String startDate) {
		
		String[] teamIdArray = StringUtils.split(teamIds, ",");
		Date scheduleStartDate = parseDate(startDate);
		List<Team> teams = new ArrayList<Team>();
		for (String teamId : teamIdArray) {
			if (StringUtils.isNumeric(teamId)) {
				teams.add(teamRepository.fetch(Integer.valueOf(teamId)));
			} else {
				throw new RuntimeException("Team Id should be numeric");
			}
		}
		return matchScheduler.generate(teams, scheduleStartDate);
	}
	
	private Date parseDate(String startDate) {
		DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return dateFormatter.parse(startDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
