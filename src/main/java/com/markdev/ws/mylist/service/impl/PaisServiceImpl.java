package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.PaisMapper;
import com.markdev.ws.mylist.model.Pais;
import com.markdev.ws.mylist.repository.PaisRepository;
import com.markdev.ws.mylist.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais findById(Long id) {
        return getPais(id);
    }

    @Override
    public Pais create(PaisDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }

        return paisRepository.save(PaisMapper.fromDtoToEntity(dto));
    }

    @Override
    public Pais update(Long id, PaisDTO dto) {
        getPais(id);
        dto.setId(id);
        return paisRepository.save(PaisMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getPais(id);

        paisRepository.deleteById(id);
    }


    private Pais getPais(Long id) {
        Optional<Pais> optional = paisRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Pais não encontrado");
        }
        return optional.get();
    }
}
