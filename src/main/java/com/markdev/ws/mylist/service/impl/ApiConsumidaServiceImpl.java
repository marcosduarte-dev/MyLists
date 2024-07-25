package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.ApiConsumidaDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.ApiConsumidaMapper;
import com.markdev.ws.mylist.model.ApiConsumida;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.repository.ApiConsumidaRepository;
import com.markdev.ws.mylist.service.ApiConsumidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ApiConsumidaServiceImpl implements ApiConsumidaService {

    @Autowired
    private ApiConsumidaRepository apiConsumidaRepository;

    @Override
    public List<ApiConsumida> findAll() {
        return apiConsumidaRepository.findAll();
    }

    @Override
    public ApiConsumida findById(Long id) {
        return getApiConsumida(id);
    }

    @Override
    public ApiConsumida create(ApiConsumidaDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }

        return apiConsumidaRepository.save(ApiConsumidaMapper.fromDtoToEntity(dto));
    }

    @Override
    public ApiConsumida update(Long id, ApiConsumidaDTO dto) {
        getApiConsumida(id);
        dto.setId(id);
        return apiConsumidaRepository.save(ApiConsumidaMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getApiConsumida(id);

        apiConsumidaRepository.deleteById(id);
    }

    @Override
    public ApiConsumida toggleStatus(Long id) {
        ApiConsumida apiConsumida = getApiConsumida(id);

        if(apiConsumida.getStatus().equals("Ativo")) {
            apiConsumida.setStatus("Inativo");
        } else {
            apiConsumida.setStatus("Ativo");
        }

        return apiConsumidaRepository.save(apiConsumida);
    }


    private ApiConsumida getApiConsumida(Long id) {
        Optional<ApiConsumida> optional = apiConsumidaRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("ApiConsumida não encontrado");
        }
        return optional.get();
    }
}
