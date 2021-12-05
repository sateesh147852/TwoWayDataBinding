package com.twowaydatabinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.twowaydatabinding.R
import com.twowaydatabinding.databinding.ActivitySecondBinding
import com.twowaydatabinding.viewmodel.SecondViewModel

class SecondActivity : AppCompatActivity() {


    private lateinit var secondViewModel: SecondViewModel
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second)

        secondViewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        binding.viewModel = secondViewModel
        binding.lifecycleOwner = this
    }
}