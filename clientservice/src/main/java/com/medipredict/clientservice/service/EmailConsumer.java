package com.medipredict.clientservice.service;

import com.medipredict.clientservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveEmailMessage(String message) {
        System.out.println("📧 Sending email: \n" + message);
        // SMTP-based email sending can be done here
    }
}
