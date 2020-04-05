package com.teamproject.gitsourcemerge.com.esta.vo;

public class ComInfoVO {
	
	public ComInfoVO() {
		// TODO Auto-generated constructor stub
	}
	
	private int community_id;
	private String community_name;
	private String community_establish_date;
	private String community_category;
	private String community_description;
	private String community_aim;
	private int community_member_count;
	private String community_establish_status;
	private String community_captain;
	
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public String getCommunity_name() {
		return community_name;
	}
	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}
	public String getCommunity_establish_date() {
		return community_establish_date;
	}
	public void setCommunity_establish_date(String community_establish_date) {
		this.community_establish_date = community_establish_date;
	}
	public String getCommunity_category() {
		return community_category;
	}
	public void setCommunity_category(String community_category) {
		this.community_category = community_category;
	}
	public String getCommunity_description() {
		return community_description;
	}
	public void setCommunity_description(String community_description) {
		this.community_description = community_description;
	}
	public String getCommunity_aim() {
		return community_aim;
	}
	public void setCommunity_aim(String community_aim) {
		this.community_aim = community_aim;
	}
	public int getCommunity_member_count() {
		return community_member_count;
	}
	public void setCommunity_member_count(int community_member_count) {
		this.community_member_count = community_member_count;
	}
	public String getCommunity_establish_status() {
		return community_establish_status;
	}
	public void setCommunity_establish_status(String community_establish_status) {
		this.community_establish_status = community_establish_status;
	}
	public String getCommunity_captain() {
		return community_captain;
	}
	public void setCommunity_captain(String community_captain) {
		this.community_captain = community_captain;
	}
	
	@Override
	public String toString() {
		return "ComInfoVO [community_id=" + community_id + ", community_name=" + community_name
				+ ", community_establish_date=" + community_establish_date + ", community_category="
				+ community_category + ", community_description=" + community_description + ", community_aim="
				+ community_aim + ", community_member_count=" + community_member_count + ", community_establish_status="
				+ community_establish_status + ", community_captain=" + community_captain + "]";
	}
	
	
	
	
	

	
	
	
	

	
	
	

}
