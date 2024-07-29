package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.TiposDTO;
import com.markdev.ws.mylist.model.Tipos;

public class TiposMapper {

    public static Tipos fromDtoToEntity(TiposDTO dto) {
        return Tipos.builder()
                .id(dto.getId())
                .tipo(dto.getTipo())
                .ativo(dto.getAtivo())
                .color(dto.getColor())
                .build();
    }

}
