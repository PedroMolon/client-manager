package com.pedromolon.client_manager.mapper;

import com.pedromolon.client_manager.dto.ClientRequestDTO;
import com.pedromolon.client_manager.dto.ClientResponseDTO;
import com.pedromolon.client_manager.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientRequestDTO request);

    ClientResponseDTO toResponse(Client client);

}
