package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.UsuariosDTO;
import com.markdev.ws.mylist.model.Usuarios;

public class UsuariosMapper {

    public static Usuarios fromDtoToEntity(UsuariosDTO dto) {
        return Usuarios.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .ativo(dto.getAtivo())
                .build();
    }

}
