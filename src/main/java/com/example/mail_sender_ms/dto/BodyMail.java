package com.example.mail_sender_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BodyMail {
    private String destino;
    private String texto;
    private String asunto;
}
