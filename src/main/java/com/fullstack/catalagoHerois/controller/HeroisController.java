/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.controller;

import com.fullstack.catalagoHerois.dto.HeroiDTO;
import com.fullstack.catalagoHerois.models.Heroi;
import com.fullstack.catalagoHerois.repository.HeroiRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Simples Informatica
 */
@RestController
@RequestMapping("/herois")
public class HeroisController {
    
    @Autowired
    private HeroiRepository heroiRepository;
    
    @GetMapping(value = "/")
    public ResponseEntity listar(){
        List<Heroi> herois = (List<Heroi>) heroiRepository.findAll();
        return ResponseEntity.ok(HeroiDTO.toList(herois));
    }
    @PostMapping(value = "/")
    public ResponseEntity inserir(@RequestBody HeroiDTO heroiDTO){
        if(heroiDTO!=null){
            heroiRepository.save(new Heroi(heroiDTO));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi fornecido um heroi.");
        }
    }
}
