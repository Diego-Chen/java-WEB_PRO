/**
 * 
 */
package com.cs.关键字;

import java.security.Principal;
import java.util.Random;

/**
 * @author Administrator
 *
 */
public class FinalData {
	private static Random rand = new Random(47);
	private String id;
	
	public FinalData(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	public static final int VALUE_THREE = 39;
	private final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);
	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	private final int[] a = {1,2,3,4,5,6};
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
	}
	
	
	public static void main(String[] args) {
		String s = new String("ab" + "cd");
		System.err.println("ab" == ("a" + "b"));
	}
	
	static void test(FinalData f){
		f.id = "dd";
		System.out.println(f);
	}
	
	
}
