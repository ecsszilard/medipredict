package com.medipredict.clientservice.service;

import com.medipredict.clientservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmailMessage(String recipient, String subject, String body) {
        String message = "To: " + recipient + "\nSubject: " + subject + "\nBody: " + body;
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
    }
}
