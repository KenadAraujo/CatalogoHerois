/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.security.controller;

import com.fullstack.catalagoHerois.security.dto.RequestDTO;
import com.fullstack.catalagoHerois.security.dto.ResponseDTO;
import com.fullstack.catalagoHerois.security.service.CustomUserDetailService;
import com.fullstack.catalagoHerois.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomUserDetailService customUserDetailService;
    
    @Autowired
    private JWTUtil jWTUtil;
    
    @PostMapping(path = "/autenticar")
    public ResponseEntity<?> autenticar(@RequestBody RequestDTO requestDTO) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestDTO.getUsername(),requestDTO.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Usuario ou senha incorretos!");
        }
        final UserDetails userDetails = customUserDetailService.loadUserByUsername(requestDTO.getUsername());
        final String token = jWTUtil.generateToken(userDetails);
        return ResponseEntity.ok(new ResponseDTO(token));
    }
}
