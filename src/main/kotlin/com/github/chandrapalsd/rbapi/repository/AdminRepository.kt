package com.github.chandrapalsd.rbapi.repository

import com.github.chandrapalsd.rbapi.models.UserAdmin
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface AdminRepository: CrudRepository<UserAdmin, Int> {
    override fun findAll(): List<UserAdmin>
    override fun findById(id: Int): Optional<UserAdmin>
    @Query("SELECT u FROM UserAdmin u WHERE u.mobile = :mobile")
    fun findByMobile(@Param("mobile") mobile: String): Optional<UserAdmin>

}