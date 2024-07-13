package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.PaisDTO;
import com.markdev.ws.mylist.model.Pais;
import com.markdev.ws.mylist.service.PaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(paisService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(paisService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pais> create(@Valid @RequestBody PaisDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paisService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> update(@Valid @PathVariable("id") Long id, @RequestBody PaisDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(paisService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        paisService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
