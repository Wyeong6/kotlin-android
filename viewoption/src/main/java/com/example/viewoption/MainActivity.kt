package com.example.viewoption

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewoption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 객체 획득
        val binding = ActivityMainBinding.inflate(layoutInflater)

        // 액티비티 화면 출력
        setContentView(binding.root)

        // 뷰 객체 이용
        binding.btn1.setOnClickListener {
            binding.tv1.setText("버튼 클릭이 실행되어 text 변경됨!!!")
            binding.tv2.setBackgroundColor(Color.parseColor("#ff0000"))
        }


    }
}
