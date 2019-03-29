/**
 * 
 */
package com.cs.异常;

/**
 * @author Administrator
 *
 */
public class Number {
	public static int count(int a, int b){
		return (int)a*b;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(Number.count(1000000000, 200));
		} 
		catch (ArithmeticException e) {
			// TODO: handle exception
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
