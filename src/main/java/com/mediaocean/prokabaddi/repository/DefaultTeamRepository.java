package com.mediaocean.prokabaddi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mediaocean.prokabaddi.dao.TeamDao;
import com.mediaocean.prokabaddi.domain.Team;

@Repository
public class DefaultTeamRepository implements TeamRepository {
	
	private final TeamDao teamDao;
	
	public DefaultTeamRepository(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public Team fetch(int id) {
		Team team = teamDao.get(id);
		Assert.notNull(team, "Team does not exist for id -> "+id);
		return team;
	}

}
