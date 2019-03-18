/**
 * 
 */
package com.cs;



/**
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String[] args) {
		String addMsc = "当日充值次数*次，服务费#/笔。" ;
//		addMsc.replace("*", Long.toString(5));
//		addMsc.replace("#",  100/100.0 + "元");
		
		String s = addMsc.replace("*", Long.toString(5));
		System.out.println(s);
	}
}
