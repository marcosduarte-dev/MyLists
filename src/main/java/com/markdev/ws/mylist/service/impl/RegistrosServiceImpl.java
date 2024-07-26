package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.RegistrosDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.RegistrosMapper;
import com.markdev.ws.mylist.model.*;
import com.markdev.ws.mylist.repository.*;
import com.markdev.ws.mylist.service.RegistrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RegistrosServiceImpl implements RegistrosService {

    @Autowired
    private RegistrosRepository registrosRepository;
    @Autowired
    private ListasRepository listasRepository;
    @Autowired
    private TiposRepository tiposRepository;
    @Autowired
    private ApiConsumidaRepository apiConsumidaRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Registros> findAll() {
        return registrosRepository.findAll();
    }

    @Override
    public Registros findById(Long id) {
        return getRegistros(id);
    }

    @Override
    public Registros create(RegistrosDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }
        
        dto.setAtivo(true);

        return registrosRepository.save(RegistrosMapper.fromDtoToEntity(
                dto,
                getListas(dto),
                getTipos(dto),
                getApiConsumida(dto),
                getPais(dto),
                getStatus(dto)
        ));
    }

    @Override
    public Registros update(Long id, RegistrosDTO dto) {
        getRegistros(id);
        dto.setId(id);
        return registrosRepository.save(RegistrosMapper.fromDtoToEntity(
                dto,
                getListas(dto),
                getTipos(dto),
                getApiConsumida(dto),
                getPais(dto),
                getStatus(dto)
        ));
    }

    @Override
    public void delete(Long id) {
        getRegistros(id);

        registrosRepository.deleteById(id);
    }

    @Override
    public Registros toggleStatus(Long id) {
        Registros registros = getRegistros(id);

        registros.setAtivo(!registros.getAtivo());

        return registrosRepository.save(registros);
    }


    private Registros getRegistros(Long id) {
        Optional<Registros> optional = registrosRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Registros não encontrado");
        }
        return optional.get();
    }
    private Listas getListas(RegistrosDTO dto) {
        var opt = listasRepository.findById(dto.getListaId());
        if(opt.isEmpty()) {
            throw new NotFoundException("Listas nao encontrada");
        }
        return opt.get();
    }
    private Tipos getTipos(RegistrosDTO dto) {
        var opt = tiposRepository.findById(dto.getTipoId());
        if(opt.isEmpty()) {
            throw new NotFoundException("Tipo nao encontrado");
        }
        return opt.get();
    }
    private ApiConsumida getApiConsumida(RegistrosDTO dto) {
        var opt = apiConsumidaRepository.findById(dto.getApiConsumidaId());
        if(opt.isEmpty()) {
            throw new NotFoundException("ApiConsumida nao encontrada");
        }
        return opt.get();
    }
    private Pais getPais(RegistrosDTO dto) {
        var opt = paisRepository.findById(dto.getPaisId());
        if(opt.isEmpty()) {
            throw new NotFoundException("Pais nao encontrado");
        }
        return opt.get();
    }
    private Status getStatus(RegistrosDTO dto) {
        var opt = statusRepository.findById(dto.getStatusId());
        if(opt.isEmpty()) {
            throw new NotFoundException("Status nao encontrado");
        }
        return opt.get();
    }
}
