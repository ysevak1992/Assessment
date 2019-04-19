package com.mediaocean.prokabaddi.service.eo;

import java.util.Date;
import java.util.List;
import com.mediaocean.prokabaddi.domain.Team;
import com.mediaocean.prokabaddi.vo.Match;
public interface ProKabaddiServiceEO {
	
	List<Match> generate(List<Team> teamList, Date startDate);

}
