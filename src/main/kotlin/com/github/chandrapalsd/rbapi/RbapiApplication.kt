package com.github.chandrapalsd.rbapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "RoseBuddy API", version = "2.0", description = "Cricket Venue Booking API"))
@SecurityScheme(name = "Authorization", scheme = "bearer", type = SecuritySchemeType.HTTP, `in` = SecuritySchemeIn.HEADER)
class RbapiApplication

fun main(args: Array<String>) {
	runApplication<RbapiApplication>(*args)
}
