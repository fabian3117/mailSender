package com.example.mail_sender_ms.service;

//import com.example.mail_sender_ms.settings.JavaMailSender;
import com.example.mail_sender_ms.dto.BodyMail;
import lombok.AllArgsConstructor;
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

//@Controller
//@AllArgsConstructor
@Slf4j
@Service
public class ServiceMail {
    private static final String remitente="fabian3117@frba.utn.edu.ar";
    @Autowired
    private final JavaMailSender javaMailSender;
    @Autowired
    private final SpringTemplateEngine springTemplateEngine;

    public ServiceMail(JavaMailSender javaMailSender, SpringTemplateEngine springTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.springTemplateEngine = springTemplateEngine;
    }

    //@GetMapping("/correo")
//    @ResponseBody
    public String correo() throws MessagingException {
        Context context = new Context();
        context.setVariable("Mensaje", "John");
        String content = springTemplateEngine.process("mailtest", context);

        MimeMessage Mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(Mensaje, true);
        helper.setFrom("GBA_Resoluciones@outlook.com.ar");
        helper.setTo("fabian3117@frba.utn.edu.ar");
        helper.setSubject("subject");
        helper.setText("text");
        helper.setText(content, true);
        javaMailSender.send(Mensaje);
        return "F";
    }
    public void sendCorreo(BodyMail correo) throws MessagingException {
        MimeMessage Mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(Mensaje, true);
        helper.setFrom(remitente);
        helper.setTo(correo.getDestino());
        helper.setSubject("subject");
        helper.setText(correo.getTexto());
     //   helper.setText(content, true);
        javaMailSender.send(Mensaje);

    }
//    @Get
}
