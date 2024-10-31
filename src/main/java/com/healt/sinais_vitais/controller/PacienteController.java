package com.healt.sinais_vitais.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healt.sinais_vitais.models.PacienteModel;
import com.healt.sinais_vitais.repositories.PacienteRepository;




@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    // Metodo listar all
    @GetMapping()
    public List<PacienteModel> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Metodo listar por ID
    @GetMapping("/{id}")
    public PacienteModel adicionarDetalhe(@PathVariable Long id) {
        Optional<PacienteModel> detalhePaciente = pacienteRepository.findById(id);

        if (detalhePaciente.isPresent()){
            return detalhePaciente.get();
        }
        return null;
    }

    // Método Post
    @PostMapping
    public PacienteModel adicionarPaciente(@RequestBody PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    // UPDATE: metodo put

    @PutMapping("/{id}")
    public PacienteModel atualizarPaciente(@PathVariable Long id, @RequestBody PacienteModel pacienteAtualizado) {
        Optional<PacienteModel> pacienteExistente = pacienteRepository.findById(id);
        if(pacienteExistente.isPresent()){
            PacienteModel pacientePut = pacienteExistente.get();
            pacientePut.setNome(pacienteAtualizado.getNome());
            pacientePut.setEndereco(pacienteAtualizado.getEndereco());
            pacientePut.setTelefone(pacienteAtualizado.getTelefone());
            pacientePut.setEmail(pacienteAtualizado.getEmail());
            return pacienteRepository.save(pacientePut);

        }        
        return null;
    }
    
    //DELETE: deletando paciente por ID
    @DeleteMapping("/{id}")
    public void deletarPacientePorId(@PathVariable Long id){
        pacienteRepository.deleteById(id);
    }

    //DELETE: deletando lista de pacienteAtualizado
    @DeleteMapping
    public void deletarTodosOsPaciente(){
        pacienteRepository.deleteAll();
    }
    
    
    

    

}
