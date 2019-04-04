/**
 * 
 */
package com.cs.设计模式.抽象工厂模式;

/**
 * @author Administrator
 *
 */
public abstract class AbstractFactory {
	public abstract Color getColor(String name);
	public abstract Shape getShape(String name);
}
