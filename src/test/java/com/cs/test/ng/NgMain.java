/**
 * 
 */
package com.cs.test.ng;

/**
 * @author Administrator
 *
 */
public class NgMain {
	public static void main(String[] args) {
		int m = 100;
		
		for(int i = 0 ; i < m ;i++){
			System.out.println("连接总数:"+ m +  "剩余连接数:" + (m-i));
			ngTest(m,m-i);
		}
		
		//当n为0之后空闲连接数开始释放增大    直到t  < 0 请求恢复
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public static void ngTest(int m , int n){
		int t  = m / 8  - n;

			if (t > 0) {
			    t--;
			    System.out.println("ngx_accept_disabled:" + t);
			} else {
				//此处可以正常进行请求
			   return ;
			}
	}
}
