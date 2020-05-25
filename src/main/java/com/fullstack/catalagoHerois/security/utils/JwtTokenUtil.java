package com.fullstack.catalagoHerois.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_AUDIENCE = "audience";
	static final String CLAIM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String getUsernameFromToken(String token) {
		String username;
		Claims claims = getClaimsFromToken(token);
		username = claims.getSubject();
		return username;
	}
	
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		Claims claims = getClaimsFromToken(token);
		expiration = claims.getExpiration();
		return expiration;
	}
	
	public String refreshToken(String token) {
		String refreshedToken;
		Claims claims = getClaimsFromToken(token);
		claims.put(CLAIM_KEY_CREATED, new Date());
		refreshedToken = gerarToken(claims);
		return refreshedToken;
	}
	
	public boolean tokenValido(String token) {
		return !tokenExpirado(token);
	}
	public String obterToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority-> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
		claims.put(CLAIM_KEY_CREATED, new Date());
		return gerarToken(claims);
	}
	
	private boolean tokenExpirado(String token) {
		Date dataExpiracao = getExpirationDateFromToken(token);
		if(dataExpiracao == null) {
			return false;
		}
		return dataExpiracao.before(new Date());
	}

	private String gerarToken(Claims claims) {
		return Jwts.builder().setClaims(claims).setExpiration(gerarDataExpiracao()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	private String gerarToken(Map<String,Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(gerarDataExpiracao()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date gerarDataExpiracao() {
		return new Date(System.currentTimeMillis()+expiration*1000);
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims = null;
		claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claims;
	}
}
