package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.RegistrosDTO;
import com.markdev.ws.mylist.model.Registros;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.service.RegistrosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistrosController {

    @Autowired
    private RegistrosService registrosService;

    @GetMapping
    public ResponseEntity<List<Registros>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(registrosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registros> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(registrosService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Registros> create(@Valid @RequestBody RegistrosDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrosService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registros> update(@Valid @PathVariable("id") Long id, @RequestBody RegistrosDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(registrosService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        registrosService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Registros> toggleStatus(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(registrosService.toggleStatus(id));
    }
}
