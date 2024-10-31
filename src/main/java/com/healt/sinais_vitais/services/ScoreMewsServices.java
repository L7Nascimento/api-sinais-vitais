package com.healt.sinais_vitais.services;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healt.sinais_vitais.models.ScoreMewsModel;
import com.healt.sinais_vitais.models.SinaisVitaisModel;
import com.healt.sinais_vitais.repositories.ScoreMewsRepository;

@Service
public class ScoreMewsServices {
    private static final Logger logger = LoggerFactory.getLogger(ScoreMewsServices.class);

    @Autowired
    private ScoreMewsRepository scoreMewsRepository;

    public ScoreMewsModel calcularEAdicionarScore(SinaisVitaisModel sinaisVitais) {
        try {
            logger.info("Calculando MEWS para sinais vitais: " + sinaisVitais);
            ScoreMewsModel scoreMews = new ScoreMewsModel();
            int pontuacao = calcularMews(sinaisVitais);
            scoreMews.setPontuacao(pontuacao);
            scoreMews.setPacienteModel(sinaisVitais.getPaciente());
            scoreMews.setDataHora(LocalDateTime.now());
            ScoreMewsModel salvo = scoreMewsRepository.save(scoreMews);
            logger.info("MEWS salvo: " + salvo);
            return salvo;
        } catch (Exception e) {
            logger.error("Erro ao calcular e salvar MEWS: ", e);
            throw e;
        }
    }

    private int calcularMews(SinaisVitaisModel sinaisVitais) {
        int pontuacao = 0;
        // Implementar a lógica de cálculo aqui
        return pontuacao;
    }
}
