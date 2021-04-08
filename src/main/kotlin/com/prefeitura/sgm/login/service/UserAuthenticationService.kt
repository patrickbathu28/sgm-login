package com.prefeitura.sgm.login.service

import io.jsonwebtoken.Claims

import com.prefeitura.sgm.login.dto.DadosLogin
import com.prefeitura.sgm.login.exception.ExistingEmailException
import com.prefeitura.sgm.login.exception.ExpiredTokenException
import com.prefeitura.sgm.login.exception.InvalidLoginException
import com.prefeitura.sgm.login.exception.InvalidTokenException
import com.prefeitura.sgm.login.model.User

import com.prefeitura.sgm.login.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserAuthenticationService {

    private var userRepository: UserRepository? = null
    private var tokenService: TokenService? = null

    @Autowired
    fun UserAuthenticationService(userRepository: UserRepository?, tokenService: TokenService?) {
        this.userRepository = userRepository
        this.tokenService = tokenService
    }


    fun authenticate(dados: DadosLogin?, token: String?): User? {
        println("UserAuthenticationService.authenticate -  dados [ $dados ]  token [ $token ] ")
        val user: User? = userRepository?.findByEmail(dados?.email)
        println("UserAuthenticationService.authenticate -  user [ $user ]")
        if (token != null) {
            return if (dados?.senha == user?.senha && token == user?.token && validate(token)) {
                user
            } else {
                throw InvalidLoginException()
            }
        }else {
            throw InvalidLoginException()
        }
    }

    private fun validate(token: String?): Boolean {
        return try {
            val tokenTratado = token?.replace("Bearer ", "")
            val claims = tokenService!!.decodeToken(tokenTratado)
            println("UserAuthenticationService.validate - CreateToken " + claims!!.issuer)
            println("UserAuthenticationService.validate - CreateToken " + claims.issuedAt)
            //Verifica se o token está expirado
            if (claims.expiration.before(Date(System.currentTimeMillis()))) throw ExpiredTokenException()
            println("UserAuthenticationService.validate - ExpirationToken " + claims.expiration)
            true
        } catch (et: ExpiredTokenException) {
            et.printStackTrace()
            throw et
        } catch (e: Exception) {
            e.printStackTrace()
            throw InvalidTokenException()
        }
    }
}