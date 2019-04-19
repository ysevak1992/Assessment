package com.mediaocean.prokabaddi.repository;

import org.springframework.stereotype.Repository;

import com.mediaocean.prokabaddi.domain.Team;

@Repository
public interface TeamRepository {
	
	Team fetch(int id);
}
