package com.healt.sinais_vitais.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healt.sinais_vitais.models.PacienteModel;
import com.healt.sinais_vitais.models.SinaisVitaisModel;
import com.healt.sinais_vitais.repositories.SinaisVitaisRepository;

@Service
public class SinaisVitaisServices {
    @Autowired
    private SinaisVitaisRepository sinaisVitaisRepository;

    @Autowired
    private ScoreMewsServices scoreMewsService;

    public List<SinaisVitaisModel> listarTodos() {
        return sinaisVitaisRepository.findAll();
    }

    public SinaisVitaisModel salvar(SinaisVitaisModel sinaisVitais) {
        SinaisVitaisModel salvo = sinaisVitaisRepository.save(sinaisVitais);
        scoreMewsService.calcularEAdicionarScore(salvo);
        // Popula os dados do paciente
        if (salvo.getPaciente() != null) {
            PacienteModel paciente = salvo.getPaciente();
            paciente.setSinaisVitais(List.of(salvo));
        }
        return salvo;
    }

    public SinaisVitaisModel buscarPorId(Long id) {
        return sinaisVitaisRepository.findById(id).orElse(null);
    }

    public void deletarPorId(Long id) {
        sinaisVitaisRepository.deleteById(id);
    }

    public void deletarTodos() {
        sinaisVitaisRepository.deleteAll();
    }
}
