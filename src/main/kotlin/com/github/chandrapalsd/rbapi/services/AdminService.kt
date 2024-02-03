package com.github.chandrapalsd.rbapi.services

import com.github.chandrapalsd.rbapi.models.UserAdmin
import com.github.chandrapalsd.rbapi.models.UserAdminReqDto
import com.github.chandrapalsd.rbapi.models.UserAdminResDto
import com.github.chandrapalsd.rbapi.repository.AdminRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class AdminService(val adminRepository: AdminRepository) {

    fun findAll(): List<UserAdmin> {
        return adminRepository.findAll()
    }

    fun findById(id: Int): UserAdmin?{
        return adminRepository.findById(id).getOrNull()
    }

    fun findByMobile(mobile: String): UserAdmin?{
        return adminRepository.findByMobile(mobile).getOrNull()
    }

    fun createAdmin(userAdminReqDto: UserAdminReqDto): UserAdminResDto{
        val passwordHash = userAdminReqDto.password // TODO
        val newAdmin = UserAdmin(0, userAdminReqDto.mobile, userAdminReqDto.name, passwordHash)
        adminRepository.save(newAdmin)
        return UserAdminResDto(newAdmin)
    }

    private fun createAuthToken(): String{TODO()}
    private fun verifyAuthToken(): Boolean{TODO()}

}