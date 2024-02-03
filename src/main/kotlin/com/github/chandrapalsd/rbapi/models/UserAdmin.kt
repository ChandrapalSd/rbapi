package com.github.chandrapalsd.rbapi.models

import jakarta.persistence.*

@Entity
data class UserAdmin(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(length = 10, unique = true, nullable = false)
    val mobile: String,

    val name: String,

    val passwordHash: String
)