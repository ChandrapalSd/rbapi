package com.github.chandrapalsd.rbapi.models

import java.sql.Date

data class BookingReqDto (
    val mobile: String,
    val clientName: String,
    val date: Date,
    val hourFrom: Int,
    val hourFor: Int
)