package com.pedromolon.client_manager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(
        @NotBlank(message = "Name cannot be null")
        String name,

        @NotBlank(message = "Email cannot be null")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "CPF cannot be null")
        String cpf
) {
}
