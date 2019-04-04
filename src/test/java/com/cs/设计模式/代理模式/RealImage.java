/**
 * 
 */
package com.cs.设计模式.代理模式;

/**
 * @author Administrator
 * 目标类
 */
public class RealImage implements Image {

	private String fileName;
	
	
	public RealImage(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	
	
	private void loadFromDisk(String fileName){
		System.out.println("Loading" + fileName);
	}
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Display" + fileName);
	}

}
