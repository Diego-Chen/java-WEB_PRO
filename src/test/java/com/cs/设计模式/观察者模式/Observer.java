/**
 * 
 */
package com.cs.设计模式.观察者模式;

/**
 * @author Administrator
 *
 */
public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
