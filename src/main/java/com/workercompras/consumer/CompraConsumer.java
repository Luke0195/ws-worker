package com.workercompras.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workercompras.model.Pedido;
import com.workercompras.service.EmailService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class CompraConsumer {

    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    @RabbitListener(queues = "${queue.name}")
    public void consumer(@Payload Message message) throws IOException {
        Pedido pedido = objectMapper.readValue(message.getBody(), Pedido.class);
        log.info(pedido.toString());
        log.info("Mensagem Recebida");
        emailService.notificarCliente(pedido.getEmail());

    }


}
