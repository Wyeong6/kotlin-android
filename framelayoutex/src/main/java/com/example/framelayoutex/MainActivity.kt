package com.example.framelayoutex

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.framelayoutex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.img1.visibility = View.VISIBLE
            binding.img2.visibility = View.INVISIBLE
        }

        binding.btn2.setOnClickListener {
            binding.img1.visibility = View.INVISIBLE
            binding.img2.visibility = View.VISIBLE
        }


        }
    }
