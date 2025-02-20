package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.TiposDTO;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.service.TiposService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TiposController {

    @Autowired
    private TiposService tiposService;

    @GetMapping
    public ResponseEntity<List<Tipos>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tiposService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipos> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tiposService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Tipos> create(@Valid @RequestBody TiposDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tiposService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipos> update(@Valid @PathVariable("id") Long id, @RequestBody TiposDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(tiposService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tiposService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tipos> toggleStatus(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tiposService.toggleStatus(id));
    }
}
