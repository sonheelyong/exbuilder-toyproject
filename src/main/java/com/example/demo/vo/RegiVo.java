package com.example.demo.vo;

public class RegiVo {

	private int regi_no;
	private String user_id;
    private String regi_date;
    private int code;
    
    public RegiVo() {}

	public RegiVo(int regi_no, String user_id, String regi_date, int code) {
		super();
		this.regi_no = regi_no;
		this.user_id = user_id;
		this.regi_date = regi_date;
		this.code = code;
	}

	public int getRegi_no() {
		return regi_no;
	}

	public void setRegi_no(int regi_no) {
		this.regi_no = regi_no;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "RegiVo [regi_no=" + regi_no + ", user_id=" + user_id + ", regi_date=" + regi_date + ", code=" + code
				+ "]";
	}

	
	
    
	
    
}
