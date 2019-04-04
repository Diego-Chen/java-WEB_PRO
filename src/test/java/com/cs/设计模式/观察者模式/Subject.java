/**
 * 
 */
package com.cs.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void notifyAllObservers(){
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
