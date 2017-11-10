/**
 * 
 */
package com.rabbit.mq.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.mq.hello.produce.Producer;

/**
 * @author SandeepRaju
 *
 */
@RestController
public class HelloController {
	
	@Autowired
	Producer producer;
	
	@RequestMapping("/send")
	public String sendMessage(@RequestParam("msg")String msg) {
		producer.produceHelloMessage(msg);
		return " Sent Message Completed";
	}
}
