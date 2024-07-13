package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.dto.UsuariosDTO;
import com.markdev.ws.mylist.model.Status;
import com.markdev.ws.mylist.model.Usuarios;

public class UsuariosMapper {

    public static Usuarios fromDtoToEntity(UsuariosDTO dto) {
        return Usuarios.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
    }

}
