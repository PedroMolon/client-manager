package com.pedromolon.client_manager.dto;

import lombok.Builder;

@Builder
public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String cpf
) {
}
