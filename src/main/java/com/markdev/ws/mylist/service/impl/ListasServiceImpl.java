package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.ListasDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.ListasMapper;
import com.markdev.ws.mylist.model.Listas;
import com.markdev.ws.mylist.model.Usuarios;
import com.markdev.ws.mylist.repository.ListasRepository;
import com.markdev.ws.mylist.repository.ListasRepository;
import com.markdev.ws.mylist.repository.UsuariosRepository;
import com.markdev.ws.mylist.service.ListasService;
import com.markdev.ws.mylist.service.ListasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ListasServiceImpl implements ListasService {

    @Autowired
    private ListasRepository listasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Listas> findAll() {
        return listasRepository.findAll();
    }

    @Override
    public Listas findById(Long id) {
        return getListas(id);
    }

    @Override
    public Listas create(ListasDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }

        Usuarios usuario = getUsuarios(dto);

        return listasRepository.save(ListasMapper.fromDtoToEntity(dto,usuario));
    }

    @Override
    public Listas update(Long id, ListasDTO dto) {
        getListas(id);
        dto.setId(id);

        return listasRepository.save(ListasMapper.fromDtoToEntity(dto, getUsuarios(dto)));
    }

    @Override
    public void delete(Long id) {
        getListas(id);

        listasRepository.deleteById(id);
    }


    private Listas getListas(Long id) {
        Optional<Listas> optional = listasRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Listas não encontrado");
        }
        return optional.get();
    }

    private Usuarios getUsuarios(ListasDTO dto) {
        var opt = usuariosRepository.findById(dto.getUsuarioId());
        if(opt.isEmpty()) {
            throw new NotFoundException("usuario nao encontrado");
        }
        return opt.get();
    }
}
