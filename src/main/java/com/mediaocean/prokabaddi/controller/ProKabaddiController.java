package com.mediaocean.prokabaddi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediaocean.prokabaddi.service.bo.ProKabaddiServiceBO;
import com.mediaocean.prokabaddi.vo.ProKabaddiInputVO;
import com.mediaocean.prokabaddi.vo.ProKabaddiOutputVO;


/**
 * @author Yogesh
 *
 */
@RestController
@RequestMapping(value= "/prokabaddi/contoller")
public class ProKabaddiController {

	
	@Autowired
	ProKabaddiServiceBO  proKabaddiServiceBO;

	/**
	 * This method call ProKabaddiServiceBO to get list of matches
	 * @param : ProKabaddiInputVO
	 * @return :List<Match>
	 */
	
	@GetMapping(value ="/matchscheduler")	
	 public ResponseEntity<List<ProKabaddiOutputVO>> matchScheduler(@Valid ProKabaddiInputVO  kabaddiInputVO ) {
		List<ProKabaddiOutputVO> matches =proKabaddiServiceBO.matchScheduler(kabaddiInputVO.getIds(), kabaddiInputVO.getDate());
		return new ResponseEntity<List<ProKabaddiOutputVO>>(matches, HttpStatus.OK);
 }
}
