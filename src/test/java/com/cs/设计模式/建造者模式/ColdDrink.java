/**
 * 
 */
package com.cs.设计模式.建造者模式;

/**
 * @author Administrator
 *
 */
public abstract class  ColdDrink implements Item {


	/* (non-Javadoc)
	 * @see com.cs.设计模式.建造者模式.Item#packing()
	 */
	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Bottle();
	}

	/* (non-Javadoc)
	 * @see com.cs.设计模式.建造者模式.Item#price()
	 */
	@Override
	public abstract float price();
	
}
