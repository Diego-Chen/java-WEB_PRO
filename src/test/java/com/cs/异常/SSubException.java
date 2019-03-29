/**
 * 
 */
package com.cs.异常;

import java.io.IOException;

/**
 * @author Administrator
 *
 */
public class SSubException extends SubException {
	/**
	 * 
	 */
	public SSubException() {
		// TODO Auto-generated constructor stub
		super("子类的异常");
	}
	
	
	public void test() throws IOException,RuntimeException{}
}
