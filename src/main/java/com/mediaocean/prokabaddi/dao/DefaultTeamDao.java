package com.mediaocean.prokabaddi.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.mediaocean.prokabaddi.domain.Team;

@Component
public class DefaultTeamDao implements TeamDao {
	
	private Map<Integer, Team> teamMap = new ConcurrentHashMap<Integer, Team>();
	
	public DefaultTeamDao() {
		initializeTeam();
	}
	
	// As soon as DB supports get added below method should get removed.
	private void initializeTeam() {
		teamMap.put(1, prepareTeam(1, "BENGEL-WAARRIORS", "BENGEL WAARRIORS", "KOLKATA"));
		teamMap.put(2, prepareTeam(2, "BENGULURU-BULLS", "BENGULURU-BULLS", "BENGULURU"));
		teamMap.put(3, prepareTeam(3, "PATNA-PIRATES", "PATNA PIRATES", "GUJARAT"));
		teamMap.put(4, prepareTeam(4, "HARYANA-STEELERS", "HARYANA STEELERS", "HARYANA"));
		teamMap.put(5, prepareTeam(5, "JAIPUR-PINK-PANTHERS", "JAIPUR-PINK-PANTHERS", "RAJASTHAN"));
	}
	
	private Team prepareTeam(int id, String name, String description, String city) {
		Team team = new Team(id);
		team.setName(name);
		team.setDescription(description);
		team.setCity(city);
		return team;
	}

	@Override
	public Team get(int id) {
		//  As soon as DB supports get added team information should get fetched from DB.
		return teamMap.get(id);
	}
}
