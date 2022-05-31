package com.iti.challenge.password

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class ItiApplication

fun main(args: Array<String>) {
	runApplication<ItiApplication>(*args)
}
