package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.model.Pais;

public class PaisMapper {

    public static Pais fromDtoToEntity(PaisDTO dto) {
        return Pais.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .sigla(dto.getSigla())
                .ativo(dto.getAtivo())
                .color(dto.getColor())
                .build();
    }

}
