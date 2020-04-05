package com.teamproject.gitsourcemerge.chat.vo;

import org.springframework.stereotype.Component;

@Component("memberVO") 
public class MemberVO {
	
	private String mem_id, mem_bookcount;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_bookcount() {
		return mem_bookcount;
	}

	public void setMem_bookcount(String mem_bookcount) {
		this.mem_bookcount = mem_bookcount;
	}

}
