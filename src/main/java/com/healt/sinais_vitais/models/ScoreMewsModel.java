package com.healt.sinais_vitais.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ScoreMewsModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PacienteModel pacienteModel;


    private int pontuação;
    private LocalDate dataHora;

    public int getPontuação() {
        return pontuação;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setPontuação(int pontuação) {
        this.pontuação = pontuação;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }
    

}
