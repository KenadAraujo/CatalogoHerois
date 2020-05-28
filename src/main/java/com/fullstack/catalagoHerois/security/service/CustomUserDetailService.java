/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.security.service;

import com.fullstack.catalagoHerois.enums.PerfilEnum;
import com.fullstack.catalagoHerois.models.Usuario;
import com.fullstack.catalagoHerois.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = Optional.ofNullable(usuarioRepository.findByLogin(login))
                .orElseThrow(()->new UsernameNotFoundException("Usuario não encontrado"));
        List<GrantedAuthority> authorityList1 = AuthorityUtils.createAuthorityList("ADMIN","USUARIO");
        List<GrantedAuthority> authorityList2 = AuthorityUtils.createAuthorityList("USUARIO");
        if(usuario.getPerfil().equals(PerfilEnum.ADMIN)){
            return new User(usuario.getLogin(), usuario.getSenha(), authorityList1);
        }else{
            return new User(usuario.getLogin(), usuario.getSenha(), authorityList2);
        }
        
    }
    
}
