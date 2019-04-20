package com.mediaocean.prokabaddi.vo;


import com.mediaocean.prokabaddi.domain.Match;
import com.mediaocean.prokabaddi.utils.ProKabaddiUtils;

public class ProKabaddiVOMapper {
	
	public static ProKabaddiOutputVO mapper(Match match){
	ProKabaddiOutputVO proKabaddiOutputVO = new ProKabaddiOutputVO();
	proKabaddiOutputVO.setTeamA(match.getTeamA());
	proKabaddiOutputVO.setTeamB(match.getTeamB());
	proKabaddiOutputVO.setLocation(match.getLocation());
	proKabaddiOutputVO.setDate(ProKabaddiUtils.formatDate(match.getDate()));
	return proKabaddiOutputVO;
	}

}
