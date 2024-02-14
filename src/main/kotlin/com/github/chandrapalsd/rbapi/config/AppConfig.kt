package com.github.chandrapalsd.rbapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
class AppConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        //return BCryptPasswordEncoder()
        @Suppress
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    fun authenticationManager(builder: AuthenticationConfiguration): AuthenticationManager? {
        return builder.authenticationManager
    }

}

