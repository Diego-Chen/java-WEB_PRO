/**
 * 
 */
package com.cs.异常;

import java.io.IOException;

/**
 * @author Administrator
 *
 */
public class SubException extends Exception {
	
	/**
	 * 
	 */
	public SubException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	public void test() throws IOException{}
	
}
