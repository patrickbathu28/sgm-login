package com.prefeitura.sgm.login.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.prefeitura.sgm.login.model.User

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
data class UserRegistrationDTO(
    var id : Long,
    val nome : String,
    val email: String,
    val senha : String,
)



