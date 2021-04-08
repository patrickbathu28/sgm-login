package com.prefeitura.sgm.login.service

import com.prefeitura.sgm.login.model.User
import org.springframework.stereotype.Service
import com.prefeitura.sgm.login.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired


@Service
class UserRegistrationService {
    private var userRepository: UserRepository? = null
    private var tokenService: TokenService? = null

    @Autowired
    fun UserRegistrationService(userRepository: UserRepository?, tokenService: TokenService?) {
        this.userRepository = userRepository
        this.tokenService = tokenService
    }

    fun registrate(user: User): User? {
        user.token = tokenService!!.generateToken(user).toString()
        println("Token : " + user.token)
        var userRegister : User? = null
        if(userRepository?.findByEmail(user.email) != null){
            userRepository?.deleteByEmail(user.email)
            userRegister =  userRepository!!.save(user)
        }else{
            userRegister =  userRepository!!.save(user)
        }

        println("User Logado : $user")
        return userRegister
    }
}