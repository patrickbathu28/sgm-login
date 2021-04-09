package com.prefeitura.sgm.login.service

import com.prefeitura.sgm.login.entities.UserCadastrado
import com.prefeitura.sgm.login.exception.InvalidLoginException
import com.prefeitura.sgm.login.model.User
import com.prefeitura.sgm.login.repository.UserCadastroRepository
import com.prefeitura.sgm.login.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserRegistrationService( val userCadastradoRepository: UserCadastroRepository ) {

    private var userRepository: UserRepository? = null
    private var tokenService: TokenService? = null

    @Autowired
    fun UserRegistrationService(userRepository: UserRepository?, tokenService: TokenService?) {
        this.userRepository = userRepository
        this.tokenService = tokenService
    }

    fun registrate(user: User): User? {
        println("UserRegistrationService.registrate - start [ $user ] ")
        if (validaUsuarioRegistrado(user)!!){
            user.token = tokenService!!.generateToken(user).toString()
            println("Token : " + user.token)
            var userRegister : User? = null
            userRegister = userRepository!!.save(user)
            println("UserRegistrationService.registrate - userRegister [ $userRegister ]")
            return userRegister
        }else {
            println("UserRegistrationService.registrate - ERROR - Login Invalido")
            throw InvalidLoginException()
        }

    }

    fun validaUsuarioRegistrado(user: User) : Boolean? {
        println(userCadastradoRepository!!.findByEmail(user?.email))
        var userCadastrado : UserCadastrado? = userCadastradoRepository!!.findByEmail(user?.email)
        println("UserRegistrationService.validaUsuarioRegistrado - userCadastrado[ $userCadastrado?.email} ] ")
        if(userCadastrado?.email.equals(user?.email) && userCadastrado?.senha.equals(user?.senha) ){
            println("UserRegistrationService.validaUsuarioRegistrado - [ true ] ")
            return true
        }
        return false
    }
}