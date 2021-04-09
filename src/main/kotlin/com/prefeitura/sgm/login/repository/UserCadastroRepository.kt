package com.prefeitura.sgm.login.repository

import com.google.common.base.Optional
import com.prefeitura.sgm.login.entities.UserCadastrado
import org.springframework.data.mongodb.repository.MongoRepository


interface UserCadastroRepository : MongoRepository<UserCadastrado, String> {
    fun findByEmail(email: String?): UserCadastrado
}