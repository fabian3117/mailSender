package com.example.mail_sender_ms.enums;

import lombok.Getter;

@Getter
public enum TipoMail {
    BIENVENIDA("bienvenida"),
    FACTURA("factura");

    private final String mensaje;

    TipoMail(String mensaje) {
        this.mensaje = mensaje;
    }

}
