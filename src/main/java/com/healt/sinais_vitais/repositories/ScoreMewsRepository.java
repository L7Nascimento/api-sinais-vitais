package com.healt.sinais_vitais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healt.sinais_vitais.models.ScoreMewsModel;

@Repository
public interface ScoreMewsRepository extends JpaRepository <ScoreMewsModel, Long> {

}



