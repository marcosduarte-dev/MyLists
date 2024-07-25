package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.ListasDTO;
import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.model.Listas;
import com.markdev.ws.mylist.model.Pais;
import com.markdev.ws.mylist.model.Tipos;

import java.util.List;

public interface PaisService {

    List<Pais> findAll();

    Pais findById(Long id);

    Pais create(PaisDTO dto);

    Pais update(Long id, PaisDTO dto);

    void delete(Long id);

    Pais toggleStatus(Long id);
}
