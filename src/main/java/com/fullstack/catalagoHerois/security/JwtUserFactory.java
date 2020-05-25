package com.fullstack.catalagoHerois.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fullstack.catalagoHerois.enums.PerfilEnum;
import com.fullstack.catalagoHerois.models.Usuario;

public class JwtUserFactory {

	public static JwtUser create(Usuario usuario) {
		return new JwtUser(
				usuario.getId(), 
				usuario.getNome(), 
				usuario.getSenha(), 
				mapToGrantedAuthorities(usuario.getPerfil()));
		
	}

	private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfil) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfil.toString()));
		return authorities;
	}
}
