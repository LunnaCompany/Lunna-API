package com.company.lunna.controller;

import com.company.lunna.entitys.Message.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message") // app/mesagge
    @SendTo("/chatroom/public")
    // Este metodo sera executado quando uma mensagem é recebida em "/app/message" e o retorno desse metodo sera enciado para "/chatroom/public"
    private Message recivePublicMessage(@Payload Message message){
        return message;
    }


    @MessageMapping("/private-message")
    // Este metodo sera executado quando uma mensagem for recebida em "/private-message"
    private Message recivePrivateMessage(@Payload Message message){
        // simpMessagingTemplate envia a mensagem para um usuario especifico
        // ele recebe tres parametros: nome do usuario de destino, destino da mensagem, e a mensagem
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); // user/UserName/private
        return message;
    }
}
