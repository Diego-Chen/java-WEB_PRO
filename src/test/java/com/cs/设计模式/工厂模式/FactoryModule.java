/**
 * 
 */
package com.cs.设计模式.工厂模式;

/**
 * @author Administrator
 *
 */
public class FactoryModule {
	
	public static Shape getInstance(String className)
	{
		Shape s = null;
		if(className.equalsIgnoreCase("square")){
		    s = new Square();
		}
		else if(className.equalsIgnoreCase("Rectangle")){
			s = new Rectangle();
		}
		else if(className.equalsIgnoreCase("Circle")){
			s = new Circle();
		}
		return s;
	}
}
