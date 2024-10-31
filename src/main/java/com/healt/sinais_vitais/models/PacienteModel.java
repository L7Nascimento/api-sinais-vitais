package com.healt.sinais_vitais.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * 1 - Descrever a classe como entidade - colocando a anotação @Entity
 * 2 - Descrever o ID com a anotação @Id e definir o strategy como GenerationType = IDENTITY
 * 3 - Declarar os atributos da classe Pessoa.
 * 4 - Criar os getter e setter
 * 
 */
@Entity //1
public class PacienteModel {
    @Id//2
    @GeneratedValue(strategy=GenerationType.IDENTITY)//2
    private Long id;
 
 
    //3
    private String nome;
    private String endereco;
    private String telefone;
    private String  email;

    //4
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    






}
 