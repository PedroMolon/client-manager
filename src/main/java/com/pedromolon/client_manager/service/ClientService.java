package com.pedromolon.client_manager.service;

import com.pedromolon.client_manager.dto.ClientRequestDTO;
import com.pedromolon.client_manager.dto.ClientResponseDTO;
import com.pedromolon.client_manager.mapper.ClientMapper;
import com.pedromolon.client_manager.model.Client;
import com.pedromolon.client_manager.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientResponseDTO save(ClientRequestDTO request) {
        return clientMapper.toResponse(
                clientRepository.save(clientMapper.toEntity(request))
        );
    }

    public Page<ClientResponseDTO> findAll(Pageable pageable) {
        return clientRepository.findAllClients(pageable)
                .map(clientMapper::toResponse);
    }

    public ClientResponseDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with this id"));
    }

    public ClientResponseDTO update(Long id, ClientRequestDTO request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with this id"));

        client.setName(request.name());
        client.setEmail(request.email());
        client.setCpf(request.cpf());

        return clientMapper.toResponse(clientRepository.save(client));
    }



}
