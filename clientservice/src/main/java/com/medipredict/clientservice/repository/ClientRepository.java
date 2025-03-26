package com.medipredict.clientservice.repository;

import com.medipredict.clientservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
