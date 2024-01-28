package com.github.chandrapalsd.rbapi.services

import com.github.chandrapalsd.rbapi.models.Booking
import com.github.chandrapalsd.rbapi.models.BookingReqDto
import com.github.chandrapalsd.rbapi.repository.BookingRepository
import org.springframework.stereotype.Service
import java.sql.Date
import kotlin.jvm.optionals.getOrNull

@Service
class BookingService(val bookingRepository: BookingRepository) {

    fun findAll(): List<Booking> {
        return bookingRepository.findAll()
    }

    fun createBooking(bookingReqDto: BookingReqDto): Booking{
        var i = bookingRepository.findById(1)
        return bookingRepository.save(Booking(bookingReqDto))
    }

    fun findById(id: Int): Booking?{
        return bookingRepository.findById(id).getOrNull()
    }

    fun findByMobile(mobile: String): List<Booking>{
        return bookingRepository.findAllByMobile(mobile)
    }

    fun findByDate(date: Date): List<Booking> {
        return bookingRepository.findAllByDate(date)
    }

    fun findAllByDateRange(dateSt: Date, dateEnd: Date): List<Booking> {
        return bookingRepository.findAllByDateRange(dateSt, dateEnd)
    }

}