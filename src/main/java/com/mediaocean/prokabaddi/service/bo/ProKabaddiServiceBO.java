package com.mediaocean.prokabaddi.service.bo;

import java.util.List;


import com.mediaocean.prokabaddi.vo.ProKabaddiOutputVO;

public interface ProKabaddiServiceBO {
	
	public List<ProKabaddiOutputVO> matchScheduler(String ids ,String date);

}
