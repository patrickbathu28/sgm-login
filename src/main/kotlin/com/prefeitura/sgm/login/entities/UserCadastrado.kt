package com.prefeitura.sgm.login.entities

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Document("usuario")
data class UserCadastrado(
    @Id
    val email : String? = null,
    val senha : String? = null,
)
