package com.prefeitura.sgm.login.service

import com.prefeitura.sgm.login.model.User
import org.springframework.stereotype.Service
import io.jsonwebtoken.Jwts

import io.jsonwebtoken.Claims
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*


@Service
class TokenService {
    private val key = "String Aleatoria Secret"

    //30 minutos
    private val expirationTime: Long = 1800000

    fun generateToken(user: User?): String? {
        return Jwts.builder()
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setSubject("Teste JWT API")
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(SignatureAlgorithm.HS256, key)
            .compact()
    }

    fun decodeToken(token: String?): Claims? {
        return Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .body
    }
}