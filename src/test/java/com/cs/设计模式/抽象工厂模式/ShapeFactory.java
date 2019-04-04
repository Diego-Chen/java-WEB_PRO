/**
 * 
 */
package com.cs.设计模式.抽象工厂模式;



/**
 * @author Administrator
 * 继承抽象类的工厂类
 */
public  class ShapeFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see com.cs.设计模式.抽象工厂模式.AbstractFactory#getColor(java.lang.String)
	 */
	@Override
	public Color getColor(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cs.设计模式.抽象工厂模式.AbstractFactory#getShape(java.lang.String)
	 */
	@Override
	public Shape getShape(String name) {
		// TODO Auto-generated method stub
		Shape s = null;
		if(name.equalsIgnoreCase("square")){
		    s = new Square();
		}
		else if(name.equalsIgnoreCase("Rectangle")){
			s = new Rectangle();
		}
		else if(name.equalsIgnoreCase("Circle")){
			s = new Circle();
		}
		return s;
	}

}
