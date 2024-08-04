package com.workercompras.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workercompras.model.Pedido;
import lombok.RequiredArgsConstructor;

import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CompraConsumer {

    private final ObjectMapper objectMapper;



    @RabbitListener(queues = "${queue.name}")
    public void consumer(@Payload Message message) throws IOException {
        Pedido pedido = objectMapper.readValue(message.getBody(), Pedido.class);
        System.out.println(pedido.toString());
        System.out.println("Mensagem Recebida");
    }


}
