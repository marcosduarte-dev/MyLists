package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.dto.RegistrosDTO;
import com.markdev.ws.mylist.model.Pais;
import com.markdev.ws.mylist.model.Registros;

import java.util.List;

public interface RegistrosService {

    List<Registros> findAll();

    Registros findById(Long id);

    Registros create(RegistrosDTO dto);

    Registros update(Long id, RegistrosDTO dto);

    void delete(Long id);

}
