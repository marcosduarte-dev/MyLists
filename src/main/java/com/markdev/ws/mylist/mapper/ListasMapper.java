package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.ListasDTO;
import com.markdev.ws.mylist.model.Listas;
import com.markdev.ws.mylist.model.Usuarios;

public class ListasMapper {

    public static Listas fromDtoToEntity(ListasDTO dto, Usuarios usuario) {
        return Listas.builder()
                .id(dto.getId())
                .usuario(usuario)
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .ativo(dto.getAtivo())
                .build();
    }

}
