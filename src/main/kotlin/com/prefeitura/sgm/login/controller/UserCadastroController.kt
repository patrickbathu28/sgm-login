package com.prefeitura.sgm.login.controller

import com.prefeitura.sgm.login.entities.UserCadastrado
import com.prefeitura.sgm.login.repository.UserCadastroRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
class UserCadastroController ( val userCadastroRepository: UserCadastroRepository  ) {

    @PostMapping("v1/user/cadastro")
    fun registrate(@RequestBody user: UserCadastrado): ResponseEntity<UserCadastrado> =
         ResponseEntity.status(HttpStatus.OK).body(userCadastroRepository.save(user))

}