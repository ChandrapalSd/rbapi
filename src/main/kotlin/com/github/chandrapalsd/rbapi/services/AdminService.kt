package com.github.chandrapalsd.rbapi.services

import com.github.chandrapalsd.rbapi.models.UserAdmin
import com.github.chandrapalsd.rbapi.models.UserAdminReqDto
import com.github.chandrapalsd.rbapi.models.UserAdminResDto
import com.github.chandrapalsd.rbapi.repository.AdminRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import kotlin.jvm.optionals.getOrNull

@Service
class AdminService(val adminRepository: AdminRepository, val passwordEncoder: PasswordEncoder) :UserDetailsService {

    fun findAll(): List<UserAdminResDto> {
        return adminRepository.findAll().map { UserAdminResDto(it) }
    }

    fun findById(id: Int): UserAdminResDto?{
        val user = adminRepository.findById(id).getOrNull()
        return if(user!=null) UserAdminResDto(user) else null
    }

    fun findByMobile(mobile: String): UserAdminResDto?{
        val user = adminRepository.findByMobile(mobile).getOrNull()
        return if(user!=null) UserAdminResDto(user) else null
    }

    fun createAdmin(userAdminReqDto: UserAdminReqDto): UserAdminResDto{
        val passwordHash = passwordEncoder.encode(userAdminReqDto.password)
        val newAdmin = UserAdmin(0, userAdminReqDto.mobile, userAdminReqDto.name, passwordHash)
        adminRepository.save(newAdmin)
        return UserAdminResDto(newAdmin)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = adminRepository.findByMobile(username!!).getOrNull()
        return user?:throw RuntimeException("user Not found")
    }

}