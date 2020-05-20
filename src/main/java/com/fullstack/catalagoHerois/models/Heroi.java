/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.models;

import com.fullstack.catalagoHerois.dto.HeroiDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Heroi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "identidade_secreta")
    private String identidadeSecreta;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "poder_principal")
    private String poderPrincipal;
    
    @Column(name = "fraqueza")
    private String fraqueza;

    public Heroi() {
    }
    
    public Heroi(String identidadeSecreta, String nome, String poderPrincipal, String fraqueza) {
        this.identidadeSecreta = identidadeSecreta;
        this.nome = nome;
        this.poderPrincipal = poderPrincipal;
        this.fraqueza = fraqueza;
    }

    public Heroi(HeroiDTO heroiDTO) {
        setIdentidadeSecreta(heroiDTO.getIdentidadeSecreta());
        setNome(heroiDTO.getNome());
        setFraqueza(heroiDTO.getFraqueza());
        setPoderPrincipal(heroiDTO.getPoderPrincipal());
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentidadeSecreta() {
        return identidadeSecreta;
    }

    public void setIdentidadeSecreta(String identidadeSecreta) {
        this.identidadeSecreta = identidadeSecreta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPoderPrincipal() {
        return poderPrincipal;
    }

    public void setPoderPrincipal(String poderPrincipal) {
        this.poderPrincipal = poderPrincipal;
    }

    public String getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }
    
}
