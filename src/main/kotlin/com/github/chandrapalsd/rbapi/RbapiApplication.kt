package com.github.chandrapalsd.rbapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RbapiApplication

fun main(args: Array<String>) {
	runApplication<RbapiApplication>(*args)
}
