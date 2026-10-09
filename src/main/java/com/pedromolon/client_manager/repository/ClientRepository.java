package com.pedromolon.client_manager.repository;

import com.pedromolon.client_manager.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
    Optional<Client> findByName(String name);
    Optional<Client> findByCpf(String cpf);
    Page<Client> findAllClients(Pageable pageable);
}
