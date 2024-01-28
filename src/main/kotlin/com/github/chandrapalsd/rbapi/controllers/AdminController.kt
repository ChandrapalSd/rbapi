package com.github.chandrapalsd.rbapi.controllers

import com.github.chandrapalsd.rbapi.services.AdminService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(val adminService: AdminService) {
}