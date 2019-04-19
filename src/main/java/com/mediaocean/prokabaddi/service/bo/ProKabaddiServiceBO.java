package com.mediaocean.prokabaddi.service.bo;

import java.util.List;


import com.mediaocean.prokabaddi.vo.Match;

public interface ProKabaddiServiceBO {
	
	public List<Match> matchScheduler(String ids ,String date);

}
