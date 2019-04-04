/**
 * 
 */
package com.cs.设计模式.观察者模式;

/**
 * @author Administrator
 *
 */
public  class OctalObserver extends Observer {
	
	
	/**
	 * 
	 */
	public OctalObserver(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
		this.subject.attach(this);
	}
	

	/* (non-Javadoc)
	 * @see com.cs.设计模式.观察者模式.Observer#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Octal String:" + Integer.toOctalString(subject.getState()));
	}

}
