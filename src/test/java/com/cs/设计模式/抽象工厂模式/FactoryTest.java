/**
 * 
 */
package com.cs.设计模式.抽象工厂模式;

/**
 * @author Administrator
 *
 */
public class FactoryTest {
	
	public static void main(String[] args) {
		AbstractFactory pro = FactoryPro.getFactory("ColorFactory");
		Color cf = pro.getColor("Red");
		cf.fill();
		
		AbstractFactory pro1 = FactoryPro.getFactory("ShapeFactory");
		Shape sh = pro1.getShape("square");
		sh.draw();
		
	}
}
