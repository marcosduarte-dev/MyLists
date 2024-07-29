package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.model.Status;

public class StatusMapper {

    public static Status fromDtoToEntity(StatusDTO dto) {
        return Status.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .ativo(dto.getAtivo())
                .color(dto.getColor())
                .build();
    }

}
