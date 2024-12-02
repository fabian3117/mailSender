package com.example.mail_sender_ms.kafka.consumer;

import com.example.mail_sender_ms.controller.MailController;
import com.example.mail_sender_ms.dto.BodyMail;
import com.example.mail_sender_ms.service.ServiceMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@Slf4j
public class kafkaLister {
@Autowired
private ServiceMail serviceMail;

    private static final String TopicMailsLister="error_facturacion";
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @KafkaListener(topics = TopicMailsLister, groupId = "group1")
    void listener(BodyMail key)  throws Exception{


        serviceMail.sendCorreo(key);
        log.info("Received message [{}] in group1", key);

    }
    @ExceptionHandler
    public void exception(Exception ex){
        log.error(ex.getMessage());
    }

    }
