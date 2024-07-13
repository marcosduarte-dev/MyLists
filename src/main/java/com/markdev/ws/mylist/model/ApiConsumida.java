package com.markdev.ws.mylist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos")
public class ApiConsumida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String api;

    private String url;
}
