package com.example.mail_sender_ms.controller;

import com.example.mail_sender_ms.dto.BodyMail;
import com.example.mail_sender_ms.exceptions.HandleException;
import com.example.mail_sender_ms.service.ServiceMail;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller("/")
@Slf4j
@AllArgsConstructor

public class MailController {
    private final ServiceMail serviceMail;

    @PostMapping("/correo")
    @ResponseBody
    public void correo(@NonNull @RequestBody BodyMail bodyMail) throws MessagingException {

        serviceMail.sendCorreo(bodyMail);
    }
}
