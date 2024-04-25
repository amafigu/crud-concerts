package com.tierrayaire.repository;

import com.tierrayaire.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository <Concert, Long> {

}
