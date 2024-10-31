package com.healt.sinais_vitais.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.healt.sinais_vitais.models.SinaisVitaisModel;
import com.healt.sinais_vitais.repositories.SinaisVitaisRepository;

@RestController
@RequestMapping("/sinais-vitais")
public class SinaisVitaisController {

    @Autowired
    private SinaisVitaisRepository sinaisVitaisRepository;

    @GetMapping
    public List<SinaisVitaisModel> listarSinaisVitais() {
        return sinaisVitaisRepository.findAll();
    }

    @PostMapping
    public SinaisVitaisModel adicionarSinaisVitais(@RequestBody SinaisVitaisModel sinaisVitaisModel) {
        return sinaisVitaisRepository.save(sinaisVitaisModel);
    }

    @GetMapping("/{id}")
    public SinaisVitaisModel listarSinaisPorId(@PathVariable Long id) {
        Optional<SinaisVitaisModel> sinaisVitaisDetalhes = sinaisVitaisRepository.findById(id);
        if (sinaisVitaisDetalhes.isPresent()) {
            return sinaisVitaisDetalhes.get();
        }
        return null;
    }

    @PutMapping("/{id}")
    public SinaisVitaisModel atualizaSinaisVitais(@PathVariable Long id, @RequestBody SinaisVitaisModel sinaisVitaisAtualizado) {
        Optional<SinaisVitaisModel> atualizandoSinaisVitais = sinaisVitaisRepository.findById(id);
        if(atualizandoSinaisVitais.isPresent()){
            SinaisVitaisModel sinaisVitais =  atualizandoSinaisVitais.get();
            sinaisVitais.setFrequenciaCardiaca(sinaisVitaisAtualizado.getFrequenciaCardiaca());
            sinaisVitais.setFrequenciaRespiratoria(sinaisVitaisAtualizado.getFrequenciaRespiratoria());
            sinaisVitais.setPressaoSistolica(sinaisVitaisAtualizado.getPressaoSistolica());
            sinaisVitais.setPressaoDiastolica(sinaisVitaisAtualizado.getPressaoDiastolica());
            sinaisVitais.setSaturacao(sinaisVitaisAtualizado.getSaturacao());
            sinaisVitais.setTemperatura(sinaisVitaisAtualizado.getTemperatura());
            return sinaisVitaisRepository.save(sinaisVitais);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarSinaisPorID(@PathVariable Long id) {
        sinaisVitaisRepository.deleteById(id);
    }

    @DeleteMapping
    public void deletarTodosSinaisVitais() {
        sinaisVitaisRepository.deleteAll();
    }
}
