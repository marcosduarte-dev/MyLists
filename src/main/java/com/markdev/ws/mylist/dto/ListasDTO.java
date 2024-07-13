package com.markdev.ws.mylist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListasDTO {

    private Long id;

    @NotNull
    private Long usuarioId;

    @NotBlank(message = "não pode ser nulo")
    private String titulo;

    private String descricao;
}
