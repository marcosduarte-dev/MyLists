package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.ApiConsumidaDTO;
import com.markdev.ws.mylist.dto.ListasDTO;
import com.markdev.ws.mylist.model.ApiConsumida;
import com.markdev.ws.mylist.model.Listas;
import com.markdev.ws.mylist.model.Tipos;

import java.util.List;

public interface ListasService {

    List<Listas> findAll();

    Listas findById(Long id);

    Listas create(ListasDTO dto);

    Listas update(Long id, ListasDTO dto);

    void delete(Long id);

}
