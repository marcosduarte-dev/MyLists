package com.markdev.ws.mylist.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registros")
public class Registros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Listas lista;

    private String poster;

    private String nome;

    private String sinopse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tipos tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apiconsumida_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ApiConsumida apiConsumida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Status status;

    private Long temporadas;

    @Column(name = "total_episodios")
    private Long totalEpisodios;

    @Column(name = "episodios_assistidos")
    private Long episodiosAssistidos;

    private Long rating;

    private String comentarios;

    @Column(name = "data_comeco")
    private LocalDate dataComeco;

    @Column(name = "data_final")
    private LocalDate dataFinal;

    @Column(name = "data_registro")
    private LocalDate dataRegistro;

    private Boolean ativo;
}
