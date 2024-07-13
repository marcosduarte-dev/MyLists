package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.ListasDTO;
import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.model.Listas;
import com.markdev.ws.mylist.model.Pais;
import com.markdev.ws.mylist.model.Usuarios;

public class PaisMapper {

    public static Pais fromDtoToEntity(PaisDTO dto) {
        return Pais.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .sigla(dto.getSigla())
                .build();
    }

}
