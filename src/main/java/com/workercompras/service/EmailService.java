package com.workercompras.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Slf4j
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void notificarCliente(String email){
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(email);
      message.setSubject("Compra Notificação.");
      message.setText("Este é um e-mail de confimação de compra recebida." + "Agora vamos aprovar sua compra e brevemente você recebera um novo e-mail de confirmação" + "\n Obrigado por comprar com a gente!!");
      javaMailSender.send(message);
      log.info("Cliente notificado com sucesso!");
    }
}
