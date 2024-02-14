package com.github.chandrapalsd.rbapi.config

import com.github.chandrapalsd.rbapi.security.JwtAuthenticationEntryPoint
import com.github.chandrapalsd.rbapi.security.JwtAuthenticationFilter
import org.apache.catalina.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
class SecurityConfig {
    @Autowired
    private lateinit var point: JwtAuthenticationEntryPoint

    @Autowired
    private lateinit var filter: JwtAuthenticationFilter

    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/admin/**").authenticated()
                    .requestMatchers("/auth/login", "/swagger-ui/**", "v3/api-docs/**", "/booking/**").permitAll()
                    .anyRequest().authenticated()
            }
            .exceptionHandling { ex -> ex.authenticationEntryPoint(point) }
            .sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        return DaoAuthenticationProvider().apply {
            setUserDetailsService(userDetailsService)
            setPasswordEncoder(passwordEncoder)
        }
    }

}