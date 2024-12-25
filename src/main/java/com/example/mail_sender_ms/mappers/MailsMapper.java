package com.example.mail_sender_ms.mappers;

import com.example.mail_sender_ms.dto.BodyMail;
import com.example.mail_sender_ms.models.MailsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

@Mapper(componentModel = "spring")
public interface MailsMapper {
    BodyMail MailEntityToMailDTO(MailsModel mailsModel);
    MailsModel MailDTOToMailEntity(BodyMail bodyMail);



}
