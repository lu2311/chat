package com.semana11.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Habilita el soporte para WebSockets con Broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Habilita el Simple Broker (en memoria) para destinos /topic
        config.enableSimpleBroker("/topic");
        // Prefijo para endpoints dirigidos al @Controller (Embudo de la Aplicación)
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registra el endpoint de conexión /ws y habilita SockJS para fallbacks
        registry.addEndpoint("/ws").withSockJS();
    }
}