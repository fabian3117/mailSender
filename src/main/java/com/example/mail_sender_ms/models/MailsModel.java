package com.example.mail_sender_ms.models;

import com.example.mail_sender_ms.enums.TipoMail;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
//@EnableJpaRepositories
@Table
public class MailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String destino;
    private String texto;
    private String asunto;
    @Enumerated(EnumType.STRING)
    private TipoMail tipo;

}
