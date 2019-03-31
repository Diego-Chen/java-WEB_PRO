/**
 * 
 */
package com.cs.base.msa.继承;

/**
 * @author Administrator
 *
 */
public class SubClass extends SuperClass{
	static{
		System.out.println("c");
	}
	
	/**
	 * 
	 */
	public SubClass() {
		// TODO Auto-generated constructor stub
		System.out.println("d");
	}
	
	public static void main(String[] args) {
		//a,c,g,b,d,h,
		SuperClass c = new SSubClass();
		System.out.println("--------------");
		//b,d,h
		c = new SSubClass();
	}
}
