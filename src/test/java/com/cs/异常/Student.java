/**
 * 
 */
package com.cs.异常;

/**
 * @author Administrator
 *
 */
public class Student {
	public void speak(int m) throws MyException{
		if(m > 1000){
			throw new MyException("参数不能大于1000");
		}
		System.out.println("传入的参数为:" + m);
	}
	
	public static void main(String[] args) {
		Student st = new Student();
		try {
			st.speak(100000);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
