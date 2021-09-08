package com.prefeitura.sgm.login.config

import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class EurekaConfig ( val eurekaClient: EurekaClient? ) {

    fun serviceUrl(): String? =
        eurekaClient!!.getNextServerFromEureka("STORES", false).homePageUrl

}