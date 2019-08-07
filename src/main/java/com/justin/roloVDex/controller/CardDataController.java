package com.justin.roloVDex.controller;

import com.justin.roloVDex.model.CardData;
import com.justin.roloVDex.services.CardDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/carddata")
public class CardDataController {

    private CardDataService service;

    public CardDataController(CardDataService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CardData>> index() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardData> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardData> post(@RequestBody CardData data) {
        return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardData> put(@PathVariable Long id, @RequestBody CardData data) {
        return new ResponseEntity<>(service.update(id, data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
