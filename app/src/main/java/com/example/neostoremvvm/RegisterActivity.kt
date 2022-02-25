package com.example.neostoremvvm

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neostoremvvm.dataclass.User
import com.example.neostoremvvm.dataclass.UserResponse
import com.example.neostoremvvm.model.RegisterViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegisterActivity : AppCompatActivity(){
    lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initViewModel()
        btnRegister.setOnClickListener {
            createUser()
        }
    }
    private fun createUser() {
        val user = User(
            txtInputFirstName.editText?.text.toString().trim(),
            txtInputLastName.editText?.text.toString().trim(),
            txtInputEmail.editText?.text.toString().trim(),
            txtInputRegPassword.editText?.text.toString().trim(),
            txtInputConfirmedPassword.editText?.text.toString().trim(),
            txtInputPhoneNumber.editText?.text.toString().trim().toDouble()
        )
        viewModel.createNewUser(user)
    }
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <UserResponse?> {
            if(it == null) {
                Toast.makeText(this@RegisterActivity,"Failed",Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this@RegisterActivity,"Successfull",Toast.LENGTH_SHORT).show()
        })
    }
}