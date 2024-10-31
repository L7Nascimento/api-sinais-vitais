package com.healt.sinais_vitais.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SinaisVitaisModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    

    private int frequenciaCardiaca;
    private int frequenciaRespiratoria;
    private int pressaoSistolica;
    private int pressaoDiastolica;
    private int saturacao;
    private Double temperatura;

    //parametro de associação entre duas tabelas
    @ManyToOne
    private PacienteModel paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public int getFrequenciaRespiratoria() {
        return frequenciaRespiratoria;
    }

    public void setFrequenciaRespiratoria(int frequenciaRespiratoria) {
        this.frequenciaRespiratoria = frequenciaRespiratoria;
    }

    public int getPressaoSistolica() {
        return pressaoSistolica;
    }

    public void setPressaoSistolica(int pressaoSistolica) {
        this.pressaoSistolica = pressaoSistolica;
    }

    public int getPressaoDiastolica() {
        return pressaoDiastolica;
    }

    public void setPressaoDiastolica(int pressaoDiastolica) {
        this.pressaoDiastolica = pressaoDiastolica;
    }

    public int getSaturacao() {
        return saturacao;
    }

    public void setSaturacao(int saturacao) {
        this.saturacao = saturacao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    

    
 // método para calcular a Pressão arterial media
    public Double getPressaoMedia(){
        return pressaoSistolica + pressaoDiastolica/2.0;
        
    }
    

}
