/**
 * 
 */
package com.cs.aop.service;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Logger {
	public static void start(){
		System.out.println(new Date() + "say hello start...");
	}
	
	
	public static void end(){
		System.out.println(new Date() + "say hello end");
	}
}
