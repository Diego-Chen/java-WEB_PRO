/**
 * 
 */
package com.cs.aop.dynamicservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * 代理类
 */
public class DynamicProxyHello implements InvocationHandler {
	//目标对象
	private Object target;
	
	//调用对象
	private Object proxy; 
	
	
	public Object bind(Object object,Object proxy){
		this.target = object;
		this.proxy = proxy;
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		//ILogger
		@SuppressWarnings("rawtypes")
		Class clazz = this.proxy.getClass();
		@SuppressWarnings("unchecked")
		Method start = clazz.getDeclaredMethod("start", new Class[]{Method.class});
		start.invoke(this.proxy, new Object[]{method});
		
		result = method.invoke(this.target, args);
		
		@SuppressWarnings("unchecked")
		Method end = clazz.getDeclaredMethod("end", new Class[]{Method.class});
		end.invoke(this.proxy,new Object[]{method});
		
		
		return result;
	}
}
