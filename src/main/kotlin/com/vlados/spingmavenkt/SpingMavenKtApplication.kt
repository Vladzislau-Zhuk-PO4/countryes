package com.vlados.spingmavenkt

import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
//import org.springframework.context.annotation.ComponentScan
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories
//import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
//@ComponentScan(basePackages = arrayOf("com.vlados.spingmavenkt.service"))
//@ComponentScan(basePackages = arrayOf("com.vlados.spingmavenkt.controller"))
//@ComponentScan(basePackages = arrayOf("com.vlados.spingmavenkt.config"))
//@EntityScan(basePackages = arrayOf("com.vlados.spingmavenkt.entity"))
//@EnableJpaRepositories(basePackages = arrayOf("come.alex.grow.repositories"))
class SpingMavenKtApplication

fun main(args: Array<String>) {
	runApplication<SpingMavenKtApplication>(*args)
}
