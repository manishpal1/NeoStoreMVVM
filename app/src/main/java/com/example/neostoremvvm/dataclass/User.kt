package com.example.neostoremvvm.dataclass

data class User(
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val confirm_password: String,
    //val gender: String,
    val phone_no: Number
)
data class UserResponse(
    val code: Int?,
    val meta: String?,
    val data: User?
)