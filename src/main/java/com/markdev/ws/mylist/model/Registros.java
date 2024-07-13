package com.markdev.ws.mylist.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registros")
public class Registros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_id")
    private Listas lista;

    private String poster;

    private String nome;

    private String sinopse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    private Tipos tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apiconsumida_id")
    private ApiConsumida apiConsumida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
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
}
