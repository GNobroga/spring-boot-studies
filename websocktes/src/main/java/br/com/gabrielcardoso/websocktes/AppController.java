package br.com.gabrielcardoso.websocktes;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {
    
    @MessageMapping("/chat-message")
    @SendTo("/chat-receive")
    public String sendMessage(String message) {
        System.out.println("message: " + message);
        return message;
    }
}
