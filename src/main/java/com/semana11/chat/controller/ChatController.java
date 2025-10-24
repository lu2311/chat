package com.semana11.chat.controller;

import com.semana11.chat.model.ChatMessage;
import com.semana11.chat.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    // Maneja mensajes enviados por el cliente al destino /app/send
    @MessageMapping("/send")
    // Difunde el valor de retorno (OutputMessage) a todos los suscriptores de
    // /topic/public
    @SendTo("/topic/public")
    public OutputMessage sendMessage(ChatMessage message) throws Exception {
        // Simulación de procesamiento de mensaje (lógica de negocio)
        Thread.sleep(100);
        // Retorna el mensaje para que el Broker lo difunda
        return new OutputMessage(message.getSender(), message.getContent());
    }
}
