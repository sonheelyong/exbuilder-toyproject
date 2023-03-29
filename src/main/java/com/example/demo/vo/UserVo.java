package com.example.demo.vo;

public class UserVo {
	private String user_id;
	private String user_name;
	private String user_pw;
	private String user_role;
	
	public UserVo() {}

	public UserVo(String user_id, String user_name, String user_pw, String user_role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_role = user_role;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_name=" + user_name + ", user_pw=" + user_pw + ", user_role="
				+ user_role + "]";
	}
	
}
