package com.medipredict.clientservice.controller;

import com.medipredict.clientservice.entity.Client;
import com.medipredict.clientservice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Endpoints for managing clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Get all clients with pagination",
            description = "Retrieves a paginated list of clients. Default page size is 10.")
    @GetMapping
    public ResponseEntity<Page<Client>> getAllClients(
            @PageableDefault(size = 10, page = 0) Pageable pageable) {
        Page<Client> clients = clientService.getAllClients(pageable);
        return ResponseEntity.ok(clients);
    }

    @Operation(summary = "Get a client by ID", description = "Retrieve details of a specific client by ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new client", description = "Adds a new client to the system.")
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @Operation(summary = "Delete a client by ID", description = "Removes a client from the system.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
