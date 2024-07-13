package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.ApiConsumidaDTO;
import com.markdev.ws.mylist.dto.TiposDTO;
import com.markdev.ws.mylist.model.ApiConsumida;
import com.markdev.ws.mylist.model.Tipos;

public class ApiConsumidaMapper {

    public static ApiConsumida fromDtoToEntity(ApiConsumidaDTO dto) {
        return ApiConsumida.builder()
                .id(dto.getId())
                .api(dto.getApi())
                .url(dto.getUrl())
                .build();
    }

}
