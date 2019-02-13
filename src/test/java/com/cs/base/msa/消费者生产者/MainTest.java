/**
 * 
 */
package com.cs.base.msa.消费者生产者;

import java.util.Vector;

/**
 * @author Administrator
 *
 */
public class MainTest {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//商品流水线
		Vector queues = new Vector();
		//商品生产最大值，生产达到该值，等待消费后继续生产
		int size = 8;
		//打个比方，一条流水线上面生产鱼罐头，流水线上有8个位置，两边各有一个机器人，机器人a负责拿个罐头盒子并且把鱼塞到盒子里面，机器人b扶着加上盖子并吧罐头从流水线拿下来装箱.
		//这里a就是生产者
		//b就是消费者,当生产线上的罐头流到b这来的时候，生产线上应该有8个待装箱的罐头了
		//下面演示生产100盒罐头的过程
		Thread pro = new Thread(new Producer(queues, size));
		Thread con = new Thread(new Consumer(queues, size));
		//机器人a开始工作
		pro.start();
		//机器人b开始工作
		con.start();
	}
}
