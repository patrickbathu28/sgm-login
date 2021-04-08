package com.prefeitura.sgm.login.controller

import com.prefeitura.sgm.login.dto.DadosLogin
import com.prefeitura.sgm.login.dto.UserAutheticatedDTO
import com.prefeitura.sgm.login.model.User
import com.prefeitura.sgm.login.service.UserAuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationController {

    private var userAuthenticationService: UserAuthenticationService? = null

    private var userAutheticatedDTO  :  UserAutheticatedDTO? = null

    @Autowired
    fun AuthenticationController(userAuthenticationService: UserAuthenticationService?) {
        this.userAuthenticationService = userAuthenticationService
    }


    @PostMapping("/login")
    fun autenticar(
        @RequestBody dadosLogin: DadosLogin?,
        @RequestHeader authorization: String?
    ): ResponseEntity<UserAutheticatedDTO> {
        val user: User? = userAuthenticationService?.authenticate(dadosLogin, authorization)
        return ResponseEntity<UserAutheticatedDTO>(user?.let { userAutheticatedDTO?.toDTO(it, "Bearer ") }, HttpStatus.ACCEPTED)
    }

}