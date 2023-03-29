package com.example.demo.vo;

public class ClassDTO {
	private int code;
	private String teacher;
	private String class_name;
	private String s_date;
	private String e_date;
	private String regi_date;
	public ClassDTO() {}
	public ClassDTO(int code, String teacher, String class_name, String s_date, String e_date, String regi_date) {
		super();
		this.code = code;
		this.teacher = teacher;
		this.class_name = class_name;
		this.s_date = s_date;
		this.e_date = e_date;
		this.regi_date = regi_date;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	public String getRegi_date() {
		return regi_date;
	}
	public void setRegi_date(String regi_date) {
		this.regi_date = regi_date;
	}
	@Override
	public String toString() {
		return "ClassDTO [code=" + code + ", teacher=" + teacher + ", class_name=" + class_name + ", s_date=" + s_date
				+ ", e_date=" + e_date + ", regi_date=" + regi_date + "]";
	}
	
	
}
