package com.markdev.ws.mylist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apiconsumida")
public class ApiConsumida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String api;

    private String url;

    private Boolean ativo;
}
