package com.medipredict.clientservice.service;

import com.medipredict.clientservice.entity.Client;
import com.medipredict.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Get all clients with pagination.
     * @param pageable Pageable object for pagination.
     * @return Page of clients.
     */
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    /**
     * Get a client by ID.
     * @param id Client ID.
     * @return Optional containing the client if found.
     */
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    /**
     * Create a new client.
     * @param client Client entity.
     * @return Saved client.
     */
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Delete a client by ID.
     * @param id Client ID.
     * @return true if deletion was successful, false if client not found.
     */
    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
