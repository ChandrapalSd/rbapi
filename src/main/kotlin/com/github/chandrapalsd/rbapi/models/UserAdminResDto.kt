package com.github.chandrapalsd.rbapi.models

data class UserAdminResDto(
    val id: Int,
    val mobile: String,
    val name: String
)
{
    constructor(userAdmin: UserAdmin) : this(
        id=userAdmin.id,
        mobile=userAdmin.mobile,
        name=userAdmin.name
    )
}