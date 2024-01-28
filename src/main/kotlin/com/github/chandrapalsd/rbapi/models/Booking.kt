package com.github.chandrapalsd.rbapi.models

import jakarta.persistence.*
import java.security.InvalidParameterException
import java.sql.Date
import java.time.Instant

@Entity
data class Booking (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int=0,

    @Column(length = 10, nullable = false)
    val mobile: String,

    val clientName: String,

    // val byAdmin: UserAdmin,

    val date: Date,

    val hourFrom: Int,
    val hourFor: Int,
    val status: Status,
    val dateCreated: Instant
)
{
    init {
        if (hourFrom < 0 || hourFrom>23){
            throw InvalidParameterException("hourFrom must be in Range [0, 23]")
        }
        if(hourFor < 1){
            throw InvalidParameterException("hourFor must be greater than 0")
        }
        if(hourFrom + hourFor > 24){
            throw InvalidParameterException("hourFrom + hourFor must be less than or equal to 24")
        }
    }

    constructor(brd: BookingReqDto) : this(
        id=0,
        mobile=brd.mobile,
        clientName=brd.clientName,
        date=brd.date,
        hourFrom=brd.hourFrom,
        hourFor=brd.hourFor,
        status=Status.PENDING,
        dateCreated= Instant.now()
    )

    enum class Status{
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}

