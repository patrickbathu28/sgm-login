package com.prefeitura.sgm.login.config

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


@EnableWebSecurity
class SecurityWebConfig: WebSecurityConfigurerAdapter() {

    override fun configure(builder: AuthenticationManagerBuilder) {
        builder
            .inMemoryAuthentication()
            .withUser("garrincha").password("123")
            .roles("USER")
            .and()
            .withUser("zico").password("123")
            .roles("USER")
    }

}