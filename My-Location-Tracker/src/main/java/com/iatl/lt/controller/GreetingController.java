package com.iatl.lt.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.iatl.lt.model.Greeting;
import com.iatl.lt.model.HelloMessage;

/**
 * @author Apu Das Gupta
 *
 */

@Controller
public class GreetingController {  


  @MessageMapping("/api/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

}


