package com.healt.sinais_vitais.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SinaisVitaisModel extends PacienteModel {
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
    private PacienteModel pacienteModel;

    //getter e setter

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public int getFrequenciaRespiratoria() {
        return frequenciaRespiratoria;
    }

    public int getPressaoSistolica() {
        return pressaoSistolica;
    }

    public int getPresssaoDiastolica() {
        return pressaoDiastolica;
    }

    public int getSaturacao() {
        return saturacao;
    }

    public Double getTemperatura() {
        return temperatura;
    }
    

   

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public void setFrequenciaRespiratoria(int frequenciaRespiratoria) {
        this.frequenciaRespiratoria = frequenciaRespiratoria;
    }

    public void setPressaoSistolica(int pressaoSistolica) {
        this.pressaoSistolica = pressaoSistolica;
    }

    public void setPressaoDiastolica(int pressaoDiastolica) {
        this.pressaoDiastolica = pressaoDiastolica;
    }

    public void setSaturacao(int saturacao) {
        this.saturacao = saturacao;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    
 // método para calcular a Pressão arterial media
    public Double getPressaoMedia(){
        return pressaoSistolica + pressaoDiastolica/2.0;
    }

    public Long getId() {
        return id;
    }
    

}
