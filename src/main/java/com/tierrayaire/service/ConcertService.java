package com.tierrayaire.service;

import com.tierrayaire.model.Concert;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ConcertService {
    List<Concert> findAll();
    Concert save(Concert concert);
    Optional<Concert> findById(Long id);
    void delete(Concert concert);
    Concert update(Long id, Concert concertDetails);
}
