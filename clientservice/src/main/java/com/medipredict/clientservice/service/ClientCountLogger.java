package com.medipredict.clientservice.service;

import com.medipredict.clientservice.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClientCountLogger {

    @Autowired
    private ClientRepository clientRepository;

    private static final Logger logger = LoggerFactory.getLogger(ClientCountLogger.class);

    @Scheduled(cron = "0 0 8 * * ?")
    public void logClientCount() {
        long count = clientRepository.count();
        System.out.println("Client count: " + count);
    }
}
