package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.ApiConsumidaDTO;
import com.markdev.ws.mylist.model.ApiConsumida;
import com.markdev.ws.mylist.model.Tipos;
import com.markdev.ws.mylist.service.ApiConsumidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiconsumida")
public class ApiConsumidaController {

    @Autowired
    private ApiConsumidaService apiconsumidaService;

    @GetMapping
    public ResponseEntity<List<ApiConsumida>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(apiconsumidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiConsumida> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(apiconsumidaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ApiConsumida> create(@Valid @RequestBody ApiConsumidaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(apiconsumidaService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiConsumida> update(@Valid @PathVariable("id") Long id, @RequestBody ApiConsumidaDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(apiconsumidaService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        apiconsumidaService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiConsumida> toggleStatus(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(apiconsumidaService.toggleStatus(id));
    }
}
