/**
 * 
 */
package com.cs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




/**
 * @author Administrator
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
//		long t =  System.currentTimeMillis();
//		StringBuffer sb = new StringBuffer("0");
//		for (int i = 0; i < 10000; i++) {
//			sb.append(i);
//		}
//		System.out.println("a的结果:" + sb.toString());
//		System.out.println("耗时为:" + (System.currentTimeMillis() - t)); //6
		
		
		
//		long t =  System.currentTimeMillis();
//		String sb = "0";
//		for (int i = 0; i < 10000; i++) {
//			sb = sb + i;
//		}
//		System.out.println("a的结果:" + sb);
//		System.out.println("耗时为:" + (System.currentTimeMillis() - t)); //179
		
		
		
//		String a = "a";
//		a = a + "b" + "c" + "d" + "e";
//		System.out.println(a);
		
		
//		StringBuffer sb = new StringBuffer("a");
//		sb.append("b");
//		sb.append("c");
//		sb.append("d");
//		sb.append("e");
//		System.out.println(sb.toString());
		
		
//		String a = "ab";
//		String b = "a" + "b" ;
//		String c = "ab";
//		String d = new String("ab");
//		String e = new String("a"+"b");
//		System.out.println(a==b);
//		System.out.println(a==c);
//		System.out.println(e==d);
//		System.err.print(a);
		
		String input = "But I'm not dead yet! I feel happy!";
//		String[] is = input.split(" ");
//		for (String string : is) {
//			System.out.println(string);
//		}
		
		Scanner ne = new Scanner(input);
		while (ne.hasNext()) {
			String string = (String) ne.next();
			System.out.println(string);
			
		}
		
		
		
	}
	
//	public static void test(String t){
//		t = t+"b";
//		System.out.println(t);
//	}
	
}
