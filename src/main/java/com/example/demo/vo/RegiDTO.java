package com.example.demo.vo;

public class RegiDTO {

	private int regi_num;
	private String user_id;
    private String regi_date;
    
    public RegiDTO() {}
    
	public RegiDTO(int regi_num, String user_id, String regi_date) {
		super();
		this.regi_num = regi_num;
		this.user_id = user_id;
		this.regi_date = regi_date;
	}
	public int getRegi_num() {
		return regi_num;
	}
	public void setRegi_num(int regi_num) {
		this.regi_num = regi_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRegi_date() {
		return regi_date;
	}
	public void setRegi_date(String regi_date) {
		this.regi_date = regi_date;
	}
	@Override
	public String toString() {
		return "RegiDTO [regi_num=" + regi_num + ", user_id=" + user_id + ", regi_date=" + regi_date + "]";
	}
    
	
    
}
