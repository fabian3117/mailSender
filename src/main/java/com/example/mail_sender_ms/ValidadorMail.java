package com.example.mail_sender_ms;

import java.util.function.Predicate;

public class ValidadorMail implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
    }

}
