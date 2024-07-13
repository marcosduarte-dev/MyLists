package com.markdev.ws.mylist.controller;

import com.markdev.ws.mylist.dto.StatusDTO;
import com.markdev.ws.mylist.model.Status;
import com.markdev.ws.mylist.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(statusService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(statusService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Status> create(@Valid @RequestBody StatusDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statusService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@Valid @PathVariable("id") Long id, @RequestBody StatusDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(statusService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        statusService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
