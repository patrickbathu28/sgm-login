package com.prefeitura.sgm.login

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
class SgmLoginApplication

fun main(args: Array<String>) {
	runApplication<SgmLoginApplication>(*args)
}
