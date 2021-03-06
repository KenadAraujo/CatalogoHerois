/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.repository;

import com.fullstack.catalagoHerois.models.Heroi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HeroiRepository extends PagingAndSortingRepository<Heroi, Long>{
    
    Heroi findByIdentidadeSecreta(String identidadeSecreta);
}
