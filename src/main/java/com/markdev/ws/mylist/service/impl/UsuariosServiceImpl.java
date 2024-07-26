package com.markdev.ws.mylist.service.impl;

import com.markdev.ws.mylist.dto.UsuariosDTO;
import com.markdev.ws.mylist.exception.BadRequestException;
import com.markdev.ws.mylist.exception.NotFoundException;
import com.markdev.ws.mylist.mapper.UsuariosMapper;
import com.markdev.ws.mylist.model.Usuarios;
import com.markdev.ws.mylist.repository.UsuariosRepository;
import com.markdev.ws.mylist.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios findById(Long id) {
        return getUsuarios(id);
    }

    @Override
    public Usuarios create(UsuariosDTO dto) {

        if(Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }
        
        dto.setAtivo(true);

        return usuariosRepository.save(UsuariosMapper.fromDtoToEntity(dto));
    }

    @Override
    public Usuarios update(Long id, UsuariosDTO dto) {
        getUsuarios(id);
        dto.setId(id);
        return usuariosRepository.save(UsuariosMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getUsuarios(id);

        usuariosRepository.deleteById(id);
    }

    @Override
    public Usuarios toggleStatus(Long id) {
        Usuarios usuario = getUsuarios(id);

        usuario.setAtivo(!usuario.getAtivo());

        return usuariosRepository.save(usuario);
    }


    private Usuarios getUsuarios(Long id) {
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Usuarios não encontrado");
        }
        return optional.get();
    }
}
