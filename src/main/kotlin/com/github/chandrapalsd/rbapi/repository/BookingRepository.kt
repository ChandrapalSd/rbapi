package com.github.chandrapalsd.rbapi.repository

import com.github.chandrapalsd.rbapi.models.Booking
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.sql.Date
import java.util.*

interface BookingRepository: CrudRepository<Booking, Int> {

    override fun findAll(): List<Booking>
    override fun findById(id: Int): Optional<Booking>

    @Query("SELECT b FROM Booking b WHERE b.mobile = :mobile")
    fun findAllByMobile(@Param("mobile") mobile: String): List<Booking>

    @Query("SELECT b FROM Booking b WHERE b.date = :date")
    fun findAllByDate(@Param("date") date: Date): List<Booking>

    @Query("SELECT b FROM Booking b WHERE b.date BETWEEN :datest AND :dateend")
    fun findAllByDateRange(@Param("datest") dateSt: Date, @Param("dateend") dateEnd: Date): List<Booking>


}