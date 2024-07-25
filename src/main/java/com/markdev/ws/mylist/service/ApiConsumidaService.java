package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.ApiConsumidaDTO;
import com.markdev.ws.mylist.model.ApiConsumida;
import com.markdev.ws.mylist.model.Tipos;

import java.util.List;

public interface ApiConsumidaService {

    List<ApiConsumida> findAll();

    ApiConsumida findById(Long id);

    ApiConsumida create(ApiConsumidaDTO dto);

    ApiConsumida update(Long id, ApiConsumidaDTO dto);

    void delete(Long id);

    ApiConsumida toggleStatus(Long id);
}
