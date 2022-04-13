package com.amu.springCloud.controller;

import com.amu.springCloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private IMessageProvider messageProvider;

    @GetMapping("/send/Message")
    public String sendMessage() {
        return messageProvider.send();
    }
}
