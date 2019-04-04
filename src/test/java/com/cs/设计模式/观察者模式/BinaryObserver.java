/**
 * 
 */
package com.cs.设计模式.观察者模式;

/**
 * @author Administrator
 *
 */
public  class BinaryObserver extends Observer{
	
	
	
	
	/**
	 * 
	 */
	public BinaryObserver(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
		this.subject.attach(this);
		
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Binary String:" +Integer.toBinaryString(subject.getState()));
	}
}
