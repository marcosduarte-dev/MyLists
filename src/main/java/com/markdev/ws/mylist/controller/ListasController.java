package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.ListasDTO;
import com.markdev.ws.mylist.model.Listas;
import com.markdev.ws.mylist.service.ListasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListasController {

    @Autowired
    private ListasService listasService;

    @GetMapping
    public ResponseEntity<List<Listas>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(listasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listas> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(listasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Listas> create(@Valid @RequestBody ListasDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(listasService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Listas> update(@Valid @PathVariable("id") Long id, @RequestBody ListasDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(listasService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        listasService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
