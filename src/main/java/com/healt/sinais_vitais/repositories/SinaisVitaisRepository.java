package com.healt.sinais_vitais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healt.sinais_vitais.models.SinaisVitaisModel;

@Repository
public interface SinaisVitaisRepository extends JpaRepository<SinaisVitaisModel, Long> {
}
