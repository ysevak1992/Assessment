package com.mediaocean.prokabaddi.service.eo;

import java.util.Date;
import java.util.List;

import com.mediaocean.prokabaddi.domain.Match;
import com.mediaocean.prokabaddi.domain.Team;
public interface ProKabaddiServiceEO {
	
	List<Match> generate(List<Team> teamList, Date startDate);

}
