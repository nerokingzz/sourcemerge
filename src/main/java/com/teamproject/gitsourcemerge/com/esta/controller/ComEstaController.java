package com.teamproject.gitsourcemerge.com.esta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.gitsourcemerge.com.esta.service.ComEstaService;
import com.teamproject.gitsourcemerge.com.esta.vo.ComInfoVO;

@Controller
public class ComEstaController {
	
	@Autowired
	private ComEstaService comEstaService;
	
	//개설신청 양식 보여주기
	@RequestMapping(value="com_esta_form", method=RequestMethod.GET)
	public String comEstaForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "com/esta/com_esta_form";
	}
	
	//개설 신청 제출
	@RequestMapping(value="com_esta_request", method=RequestMethod.POST)
	public void comEstaRequest(@ModelAttribute ComInfoVO comInfoVo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		comEstaService.comEstaRequest(comInfoVo);
	}
	
	//개설 신청 내역 (시용자 + 관리자)
	@RequestMapping(value="com_esta_request_list", method=RequestMethod.GET)
	public ModelAndView comEstaRequestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		String user_position=(String)session.getAttribute("user_position");
		
		Map<String, String> user_info=new HashMap<String, String>();
		user_info.put("user_id", user_id);
		user_info.put("user_position", user_position);
		
		ModelAndView mav=new ModelAndView();
		mav=comEstaService.comEstaRequestList(user_info);
		
		mav.setViewName("com/esta/com_esta_request_list");
		return mav;	
	}
 
}
