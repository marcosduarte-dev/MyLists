package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.UsuariosDTO;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.model.Usuarios;
import com.markdev.ws.mylist.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuarios> create(@Valid @RequestBody UsuariosDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> update(@Valid @PathVariable("id") Long id, @RequestBody UsuariosDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        usuariosService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuarios> toggleStatus(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.toggleStatus(id));
    }
}
