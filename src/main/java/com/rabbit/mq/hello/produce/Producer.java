/**
 * 
 */
package com.rabbit.mq.hello.produce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author SandeepRaju
 *
 */
@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;
	
	public void produceHelloMessage(String message){
		amqpTemplate.convertAndSend(exchange, routingKey, message);
		System.out.println("Sender Message :::: " + message);
	}
	
}
