package com.cs.base;


//private class AccessLimit 不可以编译器报错
public class AccessLimit {
	private String name;
	protected String sex;
	private String tag;
    String fault;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getFault() {
		return fault;
	}
	public void setFault(String fault) {
		this.fault = fault;
	}
    
}
