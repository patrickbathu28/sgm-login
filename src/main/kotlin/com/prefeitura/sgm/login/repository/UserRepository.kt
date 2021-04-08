package com.prefeitura.sgm.login.repository

import com.prefeitura.sgm.login.model.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, Long>  {
    fun findByEmail(email: String?): User?
    fun deleteByEmail(email: String?): User?
}