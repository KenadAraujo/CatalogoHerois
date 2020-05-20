/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.dto;

import com.fullstack.catalagoHerois.models.Heroi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;

/**
 *
 * @author Simples Informatica
 */
public class HeroiDTO implements Serializable{
    private String identidadeSecreta;
    private String nome;
    private String poderPrincipal;
    private String fraqueza;

    public HeroiDTO() {
    }

    public HeroiDTO(Heroi heroi){
        setIdentidadeSecreta(heroi.getIdentidadeSecreta());
        setNome(heroi.getNome());
        setPoderPrincipal(heroi.getPoderPrincipal());
        setFraqueza(heroi.getFraqueza());
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

    public static List<HeroiDTO> toList(List<Heroi> herois){
        List<HeroiDTO> heroisDTO = new ArrayList<>();
        for(Heroi heroi:herois){
            heroisDTO.add(new HeroiDTO(heroi));
        }
        return heroisDTO;
    }
}
