package com.example.neostoremvvm

import com.example.neostoremvvm.dataclass.User
import com.example.neostoremvvm.dataclass.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @POST("users/register")
    @Headers("Accept:application/json","Content-Type:application/json","Authorization: Bearer")
    fun createUser(@Body params: User) : Call<UserResponse>
}
