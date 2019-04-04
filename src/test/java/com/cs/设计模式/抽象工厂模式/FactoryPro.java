/**
 * 
 */
package com.cs.设计模式.抽象工厂模式;

/**
 * @author Administrator
 * 通过抽象类获取工厂实例
 */
public class FactoryPro {
	
	public static AbstractFactory getFactory(String name){
		AbstractFactory s = null;
		if(name.equalsIgnoreCase("ShapeFactory")){
			s = new ShapeFactory();
		}else if(name.equalsIgnoreCase("ColorFactory")){
			s = new ColorFactory();
		}
		return s;
	}
}
