package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.dto.UsuariosDTO;
import com.markdev.ws.mylist.model.Status;
import com.markdev.ws.mylist.model.Usuarios;

import java.util.List;

public interface UsuariosService {

    List<Usuarios> findAll();

    Usuarios findById(Long id);

    Usuarios create(UsuariosDTO dto);

    Usuarios update(Long id, UsuariosDTO dto);

    void delete(Long id);

}
