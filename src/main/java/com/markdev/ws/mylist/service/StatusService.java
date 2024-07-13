package com.markdev.ws.mylist.service;

import com.markdev.ws.mylist.dto.RegistrosDTO;
import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.model.Registros;
import com.markdev.ws.mylist.model.Status;

import java.util.List;

public interface StatusService {

    List<Status> findAll();

    Status findById(Long id);

    Status create(StatusDTO dto);

    Status update(Long id, StatusDTO dto);

    void delete(Long id);

}
