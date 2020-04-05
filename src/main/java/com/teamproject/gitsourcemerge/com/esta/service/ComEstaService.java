package com.teamproject.gitsourcemerge.com.esta.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.teamproject.gitsourcemerge.com.esta.vo.ComInfoVO;

public interface ComEstaService {
	
	public void comEstaRequest(ComInfoVO comInfoVo);
	public ModelAndView comEstaRequestList(Map<String, String> user_info);

}
