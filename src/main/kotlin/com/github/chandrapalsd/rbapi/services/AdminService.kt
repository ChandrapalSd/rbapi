package com.github.chandrapalsd.rbapi.services

import com.github.chandrapalsd.rbapi.repository.AdminRepository
import org.springframework.stereotype.Service

@Service
class AdminService(val adminRepository: AdminRepository) {

    fun getAuthToken(): Boolean{TODO()}
    fun verifyAuthToken(): Boolean{TODO()}
}