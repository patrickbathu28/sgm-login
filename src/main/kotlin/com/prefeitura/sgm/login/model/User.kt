package com.prefeitura.sgm.login.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue
    val id : Long? = null,
    var nome: String? = null,
    val email : String? = null,
    val senha : String? = null,
    var token : String? = null
)
