package com.company.lunna.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Rota principal para mensagens enviadas pelo client
        registry.setApplicationDestinationPrefixes("/app");

        // Sao os topicos que que o client se inscreve pra enviar mensagens,
        // "/chatroom" -> as mensagens sao enviadas para todos clientes inscritos nesse topico
        // "/user" -> as mensagens sao eviadas apenas para o usuario correspondente, permite uma comunicação direta
        registry.enableSimpleBroker("/chatroom", "/user");

        // Define o prefixo que o servidor usa para enviar mensagens diretamente para usuarios individuais
        registry.setUserDestinationPrefix("/user");
    }

    // Este método é usado para registrar endpoints WebSocket para os clientes se conectarem
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:5173").withSockJS();
    }
}
