/**
 * 
 */
package com.cs;




/**
 * @author Administrator
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
//		Integer a = new Integer(1);
//		Long b = new Long(1);
//		System.out.println(a.equals(b));
		Integer c = 150;
		Integer d = 150;
		int e = 150;
		System.out.println(c.equals(d));
		System.out.println(c.equals(e));
		System.out.println(c==d);
		System.out.println(c==e);
		
//		String m = new String("a");
//		String n = new String("a");
//		System.out.println(m.equals(n));
//		System.out.println(m==n);
//		Integer f1 = 100, f2 = 100;
//		Integer f3 = 150, f4 = 150;  
//		System.out.println(f1==f2);
//		System.out.println(f3==f4);
		
		Integer f1 = 100, f2 = 100;
		Integer f3 = 150, f4 = 150;  
		System.out.println(f1==f2);
		System.out.println(f3==f4);
		
		
		short s = 1;
		//s = s + 1;
		// s+1 是int类型  复制符号将一个int类型复制给short类型，会有丢失精度问题
		s += 1;//相当于s = (short)(s + 1);
		
	}
}
