package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.StatusMapper;
import com.markdev.ws.mylist.model.Status;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.repository.StatusRepository;
import com.markdev.ws.mylist.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        return getStatus(id);
    }

    @Override
    public Status create(StatusDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }

        return statusRepository.save(StatusMapper.fromDtoToEntity(dto));
    }

    @Override
    public Status update(Long id, StatusDTO dto) {
        getStatus(id);
        dto.setId(id);
        return statusRepository.save(StatusMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getStatus(id);

        statusRepository.deleteById(id);
    }

    @Override
    public Status toggleStatus(Long id) {
        Status status = getStatus(id);

        if(status.getStatusAtivo().equals("Ativo")) {
            status.setStatusAtivo("Inativo");
        } else {
            status.setStatusAtivo("Ativo");
        }

        return statusRepository.save(status);
    }


    private Status getStatus(Long id) {
        Optional<Status> optional = statusRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Status não encontrado");
        }
        return optional.get();
    }
}
