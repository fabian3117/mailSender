package com.example.mail_sender_ms.dto;

import com.example.mail_sender_ms.enums.TipoMail;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BodyMail implements Serializable  {
    private String destino;
    private String texto;
    private String asunto;
    private String tipo;
}
