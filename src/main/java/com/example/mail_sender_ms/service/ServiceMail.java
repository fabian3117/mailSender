package com.example.mail_sender_ms.service;

//import com.example.mail_sender_ms.settings.JavaMailSender;
import com.example.mail_sender_ms.dto.BodyMail;
//import com.example.mail_sender_ms.repository.MailRepository;
import com.example.mail_sender_ms.mappers.MailsMapper;
import com.example.mail_sender_ms.repository.MailRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ServiceMail {
    private static final String remitente="fabian3117@frba.utn.edu.ar";
    @Autowired
    private final JavaMailSender javaMailSender;

    @Autowired
    private MailRepository mailRepository;


    @Autowired
    private final SpringTemplateEngine springTemplateEngine;
    @Autowired
    private MailsMapper mailsMapper;

    public ServiceMail(JavaMailSender javaMailSender, SpringTemplateEngine springTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.springTemplateEngine = springTemplateEngine;
    }
    public void sendCorreo(@NonNull BodyMail correo) throws MessagingException {
        switch (correo.getTipo()){
            case "FACTURA" -> {
                //--->  Envio la plantilla definida <---
            }
            case "BIENVENIDA" -> {
                //--->  Envio plantilla de bienvenida   <---

            }
        }
        MimeMessage Mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(Mensaje, true);
        helper.setFrom(remitente);
        helper.setTo(correo.getDestino());
        helper.setSubject(correo.getAsunto());
        helper.setText(correo.getTexto());
     //   helper.setText(content, true);

        javaMailSender.send(Mensaje);
        mailRepository.save(mailsMapper.MailDTOToMailEntity(correo));

    }

    public List<BodyMail> getAllCorreos() {
        return mailRepository.findAll().stream().map(mailsMapper::MailEntityToMailDTO).toList();
//    return null;/
    }
}
