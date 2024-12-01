package com.example.mail_sender_ms.controller;

import com.example.mail_sender_ms.dto.BodyMail;
import com.example.mail_sender_ms.service.ServiceMail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller("/")
@Slf4j
@AllArgsConstructor
public class MailController {
    private final ServiceMail serviceMail;

    @GetMapping("/correo")
    @ResponseBody
    public String correo() throws MessagingException {

        serviceMail.sendCorreo(BodyMail.builder()
                        .texto("Prueba")
                        .asunto("TS")
                        .destino("fabian3117@frba.utn.edu.ar")
                .build());
        return "correo";
    }
}
