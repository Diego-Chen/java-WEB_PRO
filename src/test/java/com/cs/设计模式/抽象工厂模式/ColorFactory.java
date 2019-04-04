/**
 * 
 */
package com.cs.设计模式.抽象工厂模式;

/**
 * @author Administrator
 *
 */
public class ColorFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see com.cs.设计模式.抽象工厂模式.AbstractFactory#getColor(java.lang.String)
	 */
	@Override
	public Color getColor(String name) {
		// TODO Auto-generated method stub
		Color s = null;
		if(name.equalsIgnoreCase("Blue")){
		    s = new Blue();
		}
		else if(name.equalsIgnoreCase("Green")){
			s = new Green();
		}
		else if(name.equalsIgnoreCase("Red")){
			s = new Red();
		}
		return s;
	}

	/* (non-Javadoc)
	 * @see com.cs.设计模式.抽象工厂模式.AbstractFactory#getShape(java.lang.String)
	 */
	@Override
	public Shape getShape(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
