package com.medipredict.clientservice.service;

import com.medipredict.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClientCountLogger {

    @Autowired
    private ClientRepository clientRepository;

    @Scheduled(cron = "0 0 8 * * ?")
    public void logClientCount() {
        long count = clientRepository.count();
        System.out.println("Client count: " + count);
    }
}
