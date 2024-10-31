package com.healt.sinais_vitais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healt.sinais_vitais.models.SinaisVitaisModel;
import com.healt.sinais_vitais.services.SinaisVitaisServices;


@RestController
@RequestMapping("/sinais-vitais")
public class SinaisVitaisController {

    @Autowired
    private SinaisVitaisServices sinaisVitaisService;

    @GetMapping
    public List<SinaisVitaisModel> listarSinaisVitais() {
        return sinaisVitaisService.listarTodos();
    }

    @GetMapping("/{id}")
    public SinaisVitaisModel listarSinaisPorId(@PathVariable Long id) {
        return sinaisVitaisService.buscarPorId(id);
    }

    @PostMapping
    public SinaisVitaisModel adicionarSinaisVitais(@RequestBody SinaisVitaisModel sinaisVitaisModel) {
        return sinaisVitaisService.salvar(sinaisVitaisModel);
    }

    @PutMapping("/{id}")
    public SinaisVitaisModel atualizarSinaisVitais(@PathVariable Long id, @RequestBody SinaisVitaisModel sinaisVitaisAtualizado) {
        sinaisVitaisAtualizado.setId(id);
        return sinaisVitaisService.salvar(sinaisVitaisAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarSinaisPorId(@PathVariable Long id) {
        sinaisVitaisService.deletarPorId(id);
    }

    @DeleteMapping
    public void deletarTodosSinaisVitais() {
        sinaisVitaisService.deletarTodos();
    }
}
