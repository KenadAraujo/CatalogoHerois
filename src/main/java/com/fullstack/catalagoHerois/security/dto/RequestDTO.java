/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack.catalagoHerois.security.dto;

import java.io.Serializable;

public class RequestDTO implements Serializable{
    
    private String username;
    private String password;

    public RequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RequestDTO() {
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
