package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.model.Pais;
import com.markdev.ws.mylist.model.Status;

public class StatusMapper {

    public static Status fromDtoToEntity(StatusDTO dto) {
        return Status.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .build();
    }

}
