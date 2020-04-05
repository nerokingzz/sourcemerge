package com.teamproject.gitsourcemerge.com.esta.dao;

import java.util.List;
import java.util.Map;

import com.teamproject.gitsourcemerge.com.esta.vo.ComInfoVO;

public interface ComEstaDao {
	
	public void comEstaRequest(ComInfoVO comInfoVo);
	public List<Map<String, Object>> comEstaRequestList(Map<String, String> user_info);

}
