package com.github.chandrapalsd.rbapi.controllers

import com.github.chandrapalsd.rbapi.models.UserAdmin
import com.github.chandrapalsd.rbapi.models.UserAdminReqDto
import com.github.chandrapalsd.rbapi.models.UserAdminResDto
import com.github.chandrapalsd.rbapi.services.AdminService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@SecurityRequirement(name = "Authorization")
@RestController
@RequestMapping("/admin")
class AdminController(val adminService: AdminService) {

    @GetMapping
    fun getLoggedInUser(principal: Principal): String{
        return principal.name
    }

    @GetMapping("/all")
    fun findAll(): List<UserAdminResDto> {
        return adminService.findAll()
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): UserAdminResDto?{
        return adminService.findById(id)
    }
    @GetMapping("/mobile/{mobile}")
    fun findByMobile(@PathVariable mobile: String): UserAdminResDto?{
        return adminService.findByMobile(mobile)
    }

    @PostMapping("/register")
    fun registerAdmin(@RequestBody userAdminReqDto: UserAdminReqDto): UserAdminResDto{
        return adminService.createAdmin(userAdminReqDto)
    }

}