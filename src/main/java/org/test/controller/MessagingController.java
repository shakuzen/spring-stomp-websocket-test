package org.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.HelloMessage;

/** 
 * Created on: 2014/10/19
 * @author Tommy
 */
@Controller
public class MessagingController {
	
	@Autowired
	SimpMessagingTemplate messageTemplate;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String messagePage() {
		return "messages";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message, Principal principal) throws InterruptedException {
        Thread.sleep(3000); // simulated delay
        return new Greeting(principal.getName() + " says 'Hello, " + message.getName() + "!'");
    }
	
	public class Greeting {

	    private String content;
	    
	    public Greeting() { }

	    public Greeting(String content) {
	        this.content = content;
	    }

	    public String getContent() {
	        return content;
	    }

	}

}
