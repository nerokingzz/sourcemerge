package com.teamproject.gitsourcemerge.com.esta.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.gitsourcemerge.com.esta.dao.ComEstaDao;
import com.teamproject.gitsourcemerge.com.esta.vo.ComInfoVO;

@Service
public class ComEstaServiceImpl implements ComEstaService {

	@Autowired
	private ComEstaDao comEstaDao;

	@Override
	public void comEstaRequest(ComInfoVO comInfoVo) {
		comEstaDao.comEstaRequest(comInfoVo);
		
	}

	@Override
	public ModelAndView comEstaRequestList(Map<String, String> user_info) {
		List<Map<String, Object>> requestList=comEstaDao.comEstaRequestList(user_info);
		System.out.println("requestList에 들어있는 내용");
		System.out.println(requestList);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("requestList", requestList);
		mav.addObject("requestListSize", requestList.size());
		
		System.out.println("사이즈:"+requestList.size());
		
		return mav;
	}

}
