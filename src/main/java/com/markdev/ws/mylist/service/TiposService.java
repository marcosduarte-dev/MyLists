package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.TiposDTO;
import com.markdev.ws.mylist.model.Tipos;

import java.util.List;

public interface TiposService {

    List<Tipos> findAll();

    Tipos findById(Long id);

    Tipos create(TiposDTO dto);

    Tipos update(Long id, TiposDTO dto);

    void delete(Long id);

    Tipos toggleStatus(Long id);
}
