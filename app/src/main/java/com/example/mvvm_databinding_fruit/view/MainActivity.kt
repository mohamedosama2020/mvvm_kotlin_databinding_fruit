package com.example.mvvm_databinding_fruit.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.mvvm_databinding_fruit.viewModel.MainViewModel
import com.example.mvvm_databinding_fruit.R
import com.example.mvvm_databinding_fruit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        ).apply {
            lifecycleOwner = this@MainActivity
            viewmodel = mainViewModel
        }
        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
    }
}