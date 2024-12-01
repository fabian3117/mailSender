package com.example.mail_sender_ms.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;

@ControllerAdvice

public class HandleException {
    Logger logger = LoggerFactory.getLogger(HandleException.class);

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(RuntimeException e) {
        logger.error(e.getMessage());
    }

@ExceptionHandler(MessagingException.class)
    public void handleMessagingExceptionException(MessagingException e) {
        logger.error(e.getMessage());
    }
}
