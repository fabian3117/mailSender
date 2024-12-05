package com.example.mail_sender_ms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/plantillas")
public class PlantillaController {
    @GetMapping("")
public String plantillas() {
        return "principal";
    }
}
