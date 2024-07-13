package com.markdev.ws.mylist.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrosDTO {

    private Long id;

    @NotNull
    private Long listaId;

    private String poster;

    @NotBlank(message = "não pode ser nulo")
    private String nome;

    private String sinopse;

    @NotNull
    private Long tipoId;

    @NotNull
    private Long apiConsumidaId;

    @NotNull
    private Long paisId;

    @NotNull
    private Long statusId;

    private Long temporadas;

    private Long totalEpisodios;

    private Long episodiosAssistidos;

    private Long rating;

    private String comentarios;

    private LocalDate dataComeco;

    private LocalDate dataFinal;
}
