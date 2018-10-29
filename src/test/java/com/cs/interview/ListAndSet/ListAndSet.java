/**
 * 
 */
package com.cs.interview.ListAndSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Administrator
 *	List和Set的比较
 */
public class ListAndSet {
	@SuppressWarnings("rawtypes")
	private List list = null;
	private long start = 0;
	private long end = 0;
	
	
	public static void main(String[] args) {
		ListAndSet test = new ListAndSet();
		test.arrayListAndLinkedList();
	}
	
	/**
	 * Arraylist与LinkedList的比较
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void arrayListAndLinkedList(){
		
	
	   /*
		   1、ArrayList是实现了基于动态数组的数据结构,因为地址连续，一旦数据存储好了，查询操作效率会比较高（在内存里是连着放的）。
		   2、因为地址连续， ArrayList要移动数据,所以插入和删除操作效率比较低。
		   3、LinkedList基于链表的数据结构,地址是任意的，所以在开辟内存空间的时候不需要等一个连续的地址，对于新增和删除操作add和remove，LinedList比较占优势。
		   4、因为LinkedList要移动指针,所以查询操作性能比较低。
		   List接口有两个实现ArrayList 和 LinkedList，他们的实现原理分别是c语言中介绍的数组和链表。
		         对于插入操作，链表的结构更高效，原因是可以通过修改节点的指针 就可以完成插入操作， 而不像数组，
		   
		          适用场景分析：
		          当需要对数据进行对此访问的情况下选用ArrayList，当需要对数据进行多次增加删除修改时采用LinkedList。
	   */
		
	    list = new ArrayList();
	    start = System.currentTimeMillis();// 记录执行操作前时间        
		for (int i = 0; i < 1000000; i++) {
			list.add("Hello java.");
		}
		end = System.currentTimeMillis();// 记录执行操作后时间         
		System.out.println("ArrayList用时：" + (end - start));
		
		
//		list = new LinkedList();
//		start = System.currentTimeMillis();// 记录执行操作前时间   
//		for (int i = 0; i < 1000000; i++) {
//			list.add("Hello java.");
//		}
//		end = System.currentTimeMillis();// 记录执行操作后时间         
//		System.out.println("LinkedList用时：" + (end - start));
		
		
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("1234");
		hashSet.add(null);
		hashSet.add(null);
		
		System.out.println(hashSet.toString());
		
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("1", "1");
		hashMap.put("2", "2");
		hashMap.put("3", "3");
		hashMap.put("4", "3");
		hashMap.put("3", "7");
		hashMap.put("5", null);
		hashMap.put("6", null);
		
		System.out.println(hashMap.toString());
		
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("123");
		treeSet.add("1");
		treeSet.add("456");
//		treeSet.add(null);
		
		System.out.println(treeSet.toString());
		
	}
	
	
	
	
	
}
