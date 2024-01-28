package com.github.chandrapalsd.rbapi.controllers

import com.github.chandrapalsd.rbapi.models.Booking
import com.github.chandrapalsd.rbapi.models.BookingReqDto
import com.github.chandrapalsd.rbapi.services.BookingService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.print.Book
import java.sql.Date
import java.util.Optional

@RestController
@RequestMapping("/booking")
class BookingController(val bookingService: BookingService)  {

    @GetMapping
    fun findAll(): List<Booking>{
        return bookingService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Booking?{
        return bookingService.findById(id)
    }

    @GetMapping("/mobile/{mobile}")
    fun findByMobile(@PathVariable mobile: String): List<Booking>{
        return bookingService.findByMobile(mobile)
    }

    @GetMapping("/date/{date}")
    fun findByDate(@PathVariable date: Date): List<Booking>{
        return bookingService.findByDate(date)
    }

    @GetMapping("/date/{dateSt}/{dateEnd}")
    fun findByDate(@PathVariable dateSt: Date, @PathVariable dateEnd: Date): List<Booking>{
        return bookingService.findAllByDateRange(dateSt, dateEnd)
    }

    @PostMapping
    fun NewBooking(@RequestBody bookingReqDto: BookingReqDto): Booking{
        return bookingService.createBooking(bookingReqDto)
    }

}