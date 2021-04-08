package com.prefeitura.sgm.login.controller

import com.prefeitura.sgm.login.dto.UserAutheticatedDTO
import com.prefeitura.sgm.login.dto.UserRegistrationDTO
import com.prefeitura.sgm.login.model.User
import com.prefeitura.sgm.login.service.UserRegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserRegistrationController {

    private var userRegistrationService: UserRegistrationService? = null

    private var userAutheticatedDTO: UserAutheticatedDTO? = null

    @Autowired
    fun UserRegistrationController(userRegistrationService: UserRegistrationService?) {
        this.userRegistrationService = userRegistrationService
    }


    @PostMapping("/user")
    fun registrate(@RequestBody user: User): ResponseEntity<User> =
         ResponseEntity.status(HttpStatus.OK).body(userRegistrationService?.registrate(user))

}