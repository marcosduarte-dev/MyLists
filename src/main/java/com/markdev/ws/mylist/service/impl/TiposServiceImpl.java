package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.TiposDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.TiposMapper;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.repository.TiposRepository;
import com.markdev.ws.mylist.service.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TiposServiceImpl implements TiposService {

    @Autowired
    private TiposRepository tiposRepository;

    @Override
    public List<Tipos> findAll() {
        return tiposRepository.findAll();
    }

    @Override
    public Tipos findById(Long id) {
        return getTipos(id);
    }

    @Override
    public Tipos create(TiposDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }

        return tiposRepository.save(TiposMapper.fromDtoToEntity(dto));
    }

    @Override
    public Tipos update(Long id, TiposDTO dto) {
        getTipos(id);
        dto.setId(id);
        return tiposRepository.save(TiposMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getTipos(id);

        tiposRepository.deleteById(id);
    }


    private Tipos getTipos(Long id) {
        Optional<Tipos> optionalTipos = tiposRepository.findById(id);
        if(optionalTipos.isEmpty()) {
            throw new NotFoundException("Tipo não encontrado");
        }
        return optionalTipos.get();
    }
}
