package com.example.retrofitmarvel.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitmarvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}