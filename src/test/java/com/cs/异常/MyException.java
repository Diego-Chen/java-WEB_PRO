/**
 * 
 */
package com.cs.异常;

/**
 * @author Administrator
 *
 */
public class MyException extends Exception {
	String message;

	/**
	 * 
	 */
	public MyException(String errorMessage) {
		// TODO Auto-generated constructor stub
		message = errorMessage;
	}
	
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
}
