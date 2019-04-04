/**
 * 
 */
package com.cs.设计模式.观察者模式;

/**
 * @author Administrator
 *
 */
public class ObserverTest {
	public static void main(String[] args) {
		//被观察对象
		Subject subject = new Subject();
		//观察者监听被观察对象
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);
		
		
		//被观察对象的状态发生改变，观察者们收到通知去处理
		System.out.println("First state change:15");
		subject.setState(15);
	}
}
