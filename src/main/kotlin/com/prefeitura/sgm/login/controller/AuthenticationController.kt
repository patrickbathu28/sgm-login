package com.prefeitura.sgm.login.controller

import com.prefeitura.sgm.login.dto.DadosLogin
import com.prefeitura.sgm.login.dto.UserAutheticatedDTO
import com.prefeitura.sgm.login.model.User
import com.prefeitura.sgm.login.service.UserAuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
class AuthenticationController {

    private var userAuthenticationService: UserAuthenticationService? = null

    private var userAutheticatedDTO  :  UserAutheticatedDTO? = null

    @Autowired
    fun AuthenticationController(userAuthenticationService: UserAuthenticationService?) {
        this.userAuthenticationService = userAuthenticationService
    }


    @PostMapping("v1/login")
    fun autenticar(
        @RequestBody dadosLogin: DadosLogin?,
        @RequestHeader authorization: String?
    ): ResponseEntity<UserAutheticatedDTO> {
        val user: User? = userAuthenticationService?.authenticate(dadosLogin, authorization)
        return ResponseEntity<UserAutheticatedDTO>(user?.let { userAutheticatedDTO?.toDTO(it, "Bearer ") }, HttpStatus.ACCEPTED)
    }

    @PostMapping("v1/logout")
    fun logout(
        @RequestBody dadosLogin: DadosLogin?
    ): Unit? = userAuthenticationService?.logout(dadosLogin)

}