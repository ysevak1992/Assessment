package com.mediaocean.prokabaddi.service.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediaocean.prokabaddi.domain.Match;
import com.mediaocean.prokabaddi.domain.Team;
import com.mediaocean.prokabaddi.exception.ProKabaddiException;
import com.mediaocean.prokabaddi.repository.TeamRepository;
import com.mediaocean.prokabaddi.service.eo.ProKabaddiServiceEO;
import com.mediaocean.prokabaddi.utils.ProKabaddiUtils;
import com.mediaocean.prokabaddi.vo.ProKabaddiOutputVO;
import com.mediaocean.prokabaddi.vo.ProKabaddiVOMapper;

@Service
public class ProKabaddiServiceBOImpl implements ProKabaddiServiceBO {
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	ProKabaddiServiceEO matchScheduler;
	
	
	@Override
	public List<ProKabaddiOutputVO> matchScheduler(String teamIds, String startDate) {
		List<ProKabaddiOutputVO> list = new ArrayList<>();
		String[] teamIdArray = null ;
		if (null!=teamIds.trim()&& !teamIds.isEmpty()) {
			teamIdArray = StringUtils.split(teamIds, ",");
		}else {
			throw new ProKabaddiException("teamIds shuold not be null");
		}
		Date scheduleStartDate = ProKabaddiUtils.parseDate(startDate);
		List<Team> teams = new ArrayList<Team>();
		for (String teamId : teamIdArray) {
			if (StringUtils.isNumeric(teamId)) {
				teams.add(teamRepository.fetch(Integer.valueOf(teamId)));
			} else {
				throw new ProKabaddiException("Team Id should be numeric");
			}
		}
		List<Match> matchlList = matchScheduler.generate(teams, scheduleStartDate);
		for (Match match : matchlList) {
			 ProKabaddiOutputVO proKabaddiOutputVO  = ProKabaddiVOMapper.mapper(match);
			 list.add(proKabaddiOutputVO);
		}
		return list;
	}

}
