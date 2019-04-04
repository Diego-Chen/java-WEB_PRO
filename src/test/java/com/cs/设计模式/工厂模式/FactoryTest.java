/**
 * 
 */
package com.cs.设计模式.工厂模式;

/**
 * @author Administrator
 *
 */
public class FactoryTest {
	
	public static void main(String[] args) {
		Shape s = FactoryModule.getInstance("square");
		s.draw();
		
		Shape s1 = FactoryModule.getInstance("Rectangle");
		s1.draw();
		
		Shape s2 = FactoryModule.getInstance("Circle");
		s2.draw();
	}
}
