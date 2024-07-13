package com.markdev.ws.mylist.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDTO {

    private Long id;

    @NotBlank(message = "não pode ser nulo")
    private String nome;

    @Email(message = "invalido")
    private String email;

    private String senha;
}
