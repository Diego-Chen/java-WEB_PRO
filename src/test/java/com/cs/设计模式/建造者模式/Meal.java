/**
 * 
 */
package com.cs.设计模式.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Meal {
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item){
		items.add(item);
	}
	
	
	public float getCost(){
		float cost = 0.0f;
		for(Item item : items){
			cost += item.price();
		}
		return cost;
	}
	
	
	public void showItems(){
		for(Item item:items){
			System.out.println("Item:" + item.name());
			System.out.println(", Packing:" +item.packing().pack());
			System.out.println(", Price:" + item.price());
		}
	}
	
	
	public static void main(String[] args) {
		byte s = 0x4a;
		Byte b = new Byte(s);
		System.out.println(s==b);
		System.out.println(b.equals(s));
		
	}
	
}
