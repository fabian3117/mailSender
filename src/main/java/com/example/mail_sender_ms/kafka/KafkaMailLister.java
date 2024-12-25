package com.example.mail_sender_ms.kafka;

import com.example.mail_sender_ms.dto.BodyMail;
import com.example.mail_sender_ms.service.ServiceMail;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@Slf4j
public class KafkaMailLister {

    @Autowired
    private ServiceMail serviceMail;


    @KafkaListener(topics = "${spring.kafka.facturac}", groupId = "group1")
    private void listener(@NonNull BodyMail bodyMail) throws MessagingException {

        log.info("Received message [{}] in group1", bodyMail);
        serviceMail.sendCorreo(bodyMail);
    }

}
