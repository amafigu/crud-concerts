package com.tierrayaire.controller;

import com.tierrayaire.exception.ResourceNotFoundException;
import com.tierrayaire.model.Concert;
import com.tierrayaire.repository.ConcertRepository;
import com.tierrayaire.service.ConcertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/concerts")

public class ConcertController {

    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping("/")
    public List<Concert> getAllConcerts() {
        return concertService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concert> getConcertById(@PathVariable Long id) {
        Concert concert = concertService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Concert not found with id: " + id));
        return ResponseEntity.ok(concert);
    }

    @PostMapping("/")
    public Concert createConcert(@Valid @RequestBody Concert concert) {
        return concertService.save(concert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concert> updateConcert(@Valid @PathVariable Long id, @RequestBody Concert concertDetails) {
        Concert updatedConcert = concertService.update(id, concertDetails);
        return ResponseEntity.ok(updatedConcert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteConcert(@PathVariable Long id) {
        Concert concert = concertService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Concert not found with id: " + id));
        concertService.delete(concert);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
