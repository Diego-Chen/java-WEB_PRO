/**
 * 
 */
package com.cs.aop.dynamicservice;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class ILoggerImpl implements ILogger {

	@Override
	public void start(Method method) {
		// TODO Auto-generated method stub
		 System.out.println(new Date()+ method.getName() + " say hello start...");
	}

	@Override
	public void end(Method method) {
		// TODO Auto-generated method stub
		 System.out.println(new Date()+ method.getName() + " say hello end");
	}

}
