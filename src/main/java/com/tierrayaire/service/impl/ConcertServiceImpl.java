package com.tierrayaire.service.impl;

import com.tierrayaire.model.Concert;
import com.tierrayaire.repository.ConcertRepository;
import com.tierrayaire.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ConcertServiceImpl implements ConcertService {


    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertServiceImpl(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @Override
    public List<Concert> findAll() {
        return concertRepository.findAll();
    }

    @Override
    public Concert save(Concert concert) {
        return concertRepository.save(concert);
    }

    @Override
    public Optional<Concert> findById(Long id) {
        return concertRepository.findById(id);
    }

    @Override
    public void delete(Concert concert) {
        concertRepository.delete(concert);
    }

    @Override
    public Concert update(Long id, Concert concertDetails) {
        Concert concert = concertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Concert not found with id: " + id));
        concert.setVenue(concertDetails.getVenue());
        concert.setVenueLink(concertDetails.getVenueLink());
        concert.setCity(concertDetails.getCity());
        concert.setCountry(concertDetails.getCountry());
        concert.setTicketsLink(concertDetails.getTicketsLink());
        concert.setConcertDate(concertDetails.getConcertDate());
        return concertRepository.save(concert);
    }
}
