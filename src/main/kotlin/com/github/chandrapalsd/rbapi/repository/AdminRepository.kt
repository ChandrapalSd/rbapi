package com.github.chandrapalsd.rbapi.repository

import com.github.chandrapalsd.rbapi.models.UserAdmin
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AdminRepository: CrudRepository<UserAdmin, Int> {
    override fun findAll(): List<UserAdmin>
    override fun findById(id: Int): Optional<UserAdmin>
}