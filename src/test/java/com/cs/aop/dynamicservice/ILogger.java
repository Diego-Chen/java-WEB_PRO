/**
 * 
 */
package com.cs.aop.dynamicservice;

import java.lang.reflect.Method;

/**
 * @author Administrator
 *
 */
public interface ILogger {
	void start(Method method);
	void end(Method method);

}
