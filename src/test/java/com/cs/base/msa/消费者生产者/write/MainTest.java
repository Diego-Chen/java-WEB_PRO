/**
 * 
 */
package com.cs.base.msa.消费者生产者.write;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Administrator
 *
 */
public class MainTest {
	
	public static  List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Producer procucer = new Producer();
		Consumer consumer = new Consumer();
		Consumer consumer1 = new Consumer();
		procucer.start();
		consumer.start();
		consumer1.start();

	}
}
