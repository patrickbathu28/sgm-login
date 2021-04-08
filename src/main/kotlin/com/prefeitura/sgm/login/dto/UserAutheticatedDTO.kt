package com.prefeitura.sgm.login.dto

import com.prefeitura.sgm.login.model.User

data class UserAutheticatedDTO(

      val tipo : String? = null,
      val email: String ? = null,
      val nome : String ? = null,
      val token : String ? = null
){
      fun toDTO(user: User, tipo: String?): UserAutheticatedDTO? {
            print("UserAutheticatedDTO.toDto - User: [ $user ], Tipo : [$tipo]  ")
            return user?.token?.let { UserAutheticatedDTO(user.email, user.nome, it, tipo!!) }
      }

}
