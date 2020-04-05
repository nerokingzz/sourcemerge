package com.teamproject.gitsourcemerge.chat;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.web.servlet.config.annotation.EnableWebMvc;*/
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = { "com.bookphago.controller" })

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	
	 public void registerStompEndpoints(StompEndpointRegistry registry) {
	        registry.addEndpoint("/ws").withSockJS();
	    }

	
	 public void configureMessageBroker(MessageBrokerRegistry registry) {
	        registry.setApplicationDestinationPrefixes("/app");
	        registry.enableSimpleBroker("/topic");   // Enables a simple in-memory broker

	        /*
	        registry.enableStompBrokerRelay("/topic")
	                .setRelayHost("localhost")
	                .setRelayPort(61613)
	                .setClientLogin("guest")
	                .setClientPasscode("guest");
	        */
	    }
	
}
