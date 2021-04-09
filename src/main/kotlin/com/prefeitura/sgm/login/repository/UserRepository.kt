package com.prefeitura.sgm.login.repository

import com.prefeitura.sgm.login.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Long>  {
    fun findByEmail(email: String?): User?
    fun deleteByEmail(email: String?): User?
}