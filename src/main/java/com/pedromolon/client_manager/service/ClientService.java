package com.pedromolon.client_manager.service;

import com.pedromolon.client_manager.dto.ClientRequestDTO;
import com.pedromolon.client_manager.dto.ClientResponseDTO;
import com.pedromolon.client_manager.mapper.ClientMapper;
import com.pedromolon.client_manager.model.Client;
import com.pedromolon.client_manager.repository.ClientRepository;
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

}
