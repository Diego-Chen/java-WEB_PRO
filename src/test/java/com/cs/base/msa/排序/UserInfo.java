package com.cs.base.msa.排序;

public class UserInfo implements Comparable<UserInfo>{
	private int id;
	private String name;
	private Integer age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(UserInfo arg0) {
		// TODO Auto-generated method stub
		String temp = this.age+this.name;
		String temp1 = arg0.age + arg0.name;
		System.out.println(temp);
		System.out.println(temp1);
		return temp.compareTo(temp1);
	}
	
}
