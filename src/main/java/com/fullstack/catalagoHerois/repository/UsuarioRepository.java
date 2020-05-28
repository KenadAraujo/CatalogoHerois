/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.repository;

import com.fullstack.catalagoHerois.models.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
    
    Usuario findByLogin(String login);
}
