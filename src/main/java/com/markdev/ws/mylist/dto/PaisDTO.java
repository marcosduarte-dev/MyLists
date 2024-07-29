package com.markdev.ws.mylist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO {

    private Long id;

    @NotBlank(message = "não pode ser nulo")
    private String nome;

    private String sigla;
    
    private Boolean ativo;
    
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String color;
}
