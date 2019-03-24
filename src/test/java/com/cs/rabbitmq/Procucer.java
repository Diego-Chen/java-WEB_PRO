/**
 * 
 */
package com.cs.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Administrator
 *
 */
public class Procucer {
	private final static String QUEUE_NAME = "test_queue";
	
	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		//通过工厂类创建连接对象
		Connection connection = factory.newConnection();
		//创建一个通道
		Channel channel = connection.createChannel();
		//声明一个队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//定义消息
		String msg = "RabbitMQ";
		channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("UTF-8"));
		System.out.println("生产者发送消息:"+msg);
		
		//关闭通道
		channel.close();
		//关闭连接
		connection.close();
		
	}

}
