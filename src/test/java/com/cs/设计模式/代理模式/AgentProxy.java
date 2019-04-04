/**
 * 
 */
package com.cs.设计模式.代理模式;

/**
 * @author Administrator
 * 代理类
 */
public class AgentProxy implements Image {
	private RealImage realImage ;
	private String fileName;
	
	/**
	 * 
	 */
	public AgentProxy(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		if(null == realImage){
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
