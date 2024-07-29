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
public class TiposDTO {

    private Long id;

    @NotBlank(message = "não pode ser nulo ou vazio")
    private String tipo;

    private Boolean ativo;
    
    @NotBlank(message = "não pode ser nulo ou vazio")
    private String color;
}
