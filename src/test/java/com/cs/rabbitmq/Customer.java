/**
 * 
 */
package com.cs.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;

/**
 * @author Administrator
 *
 */
public class Customer {
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
		//声明要关注的队列
		//当所有消费者客户端连接断开时自动删除队列
		channel.queueDeclare(QUEUE_NAME, false, false, true, null);
		System.out.println("消费这等待接收消息...");
		Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, com.rabbitmq.client.Envelope envelope, com.rabbitmq.client.AMQP.BasicProperties properties, byte[] body) throws java.io.IOException {
				String msg = new String(body,"UTF-8");
				System.out.println("消费者接收到:" + msg);
			};
		};
		
		//自动回复队列应答， RabbitMQ中的消息确认机制
		channel.basicConsume(QUEUE_NAME, true , consumer);
	}
}
