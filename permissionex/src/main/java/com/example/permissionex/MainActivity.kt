package com.example.permissionex

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.permissionex.databinding.DialogInputBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
                isGranted ->
            if(isGranted) {
                Log.d("test","granted 콜백 실행됨~")
            } else {
                Log.d("test","denied 콜백 실행됨..")
            }
        }

        val callBtn = findViewById<ImageView>(R.id.callBtn)

        callBtn.setOnClickListener{
            val status = ContextCompat.checkSelfPermission(this,"android.permission.CALL_PHONE")
            if(status == PackageManager.PERMISSION_GRANTED){
                // 전화 걸기
                Toast.makeText(this, "전화를 겁니다!", Toast.LENGTH_SHORT).show()
                var intent = Intent(Intent.ACTION_CALL)
                var num = "tel:010-5259-1381"
                intent.data = Uri.parse(num)
                startActivity(intent)
            } else {
                Toast.makeText(this, "권한을 허용해주세요!", Toast.LENGTH_SHORT).show()
                // 퍼미션 허용 요청 실행
                requestPermissionLauncher.launch("android.permission.CALL_PHONE")
            }
        }

        val dateBtn = findViewById<Button>(R.id.dateBtn)
        dateBtn.setOnClickListener {
            DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("test","year: $year, month: ${month + 1}, day: $dayOfMonth")
                }
            }, 2024,3,16).show()
        }
        val timeBtn = findViewById<Button>(R.id.timeBtn)

        timeBtn.setOnClickListener {
            TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Log.d("test","hourOfday: $hourOfDay, minute: $minute")
                }
            }, 2024,4,true).show()
        }

        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    Toast.makeText(applicationContext,"네 버튼을 눌렀어요!", Toast.LENGTH_SHORT).show()
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    Toast.makeText(applicationContext,"아니오 버튼을 눌렀어요!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        // alertDialog 띄우기
        val alertBtn = findViewById<Button>(R.id.alertBtn)

        alertBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("테스트 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMessage("정말 종료하시겠습니까??")
                setPositiveButton("네", eventHandler)
                setNegativeButton("아니오", eventHandler)
                setNeutralButton("더보기", null)
                setPositiveButton("YES", eventHandler)
                setNegativeButton("NO", eventHandler)
                show()
            }
        }
        val alertCheckBtn = findViewById<Button>(R.id.alertCheckBtn)

        alertCheckBtn.setOnClickListener {
            val items = arrayOf<String>("사과","복숭아","수박","딸기")

            AlertDialog.Builder(this).run{
                setTitle("체크박스 목록 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(items, booleanArrayOf(true,false,true,false), object : DialogInterface.OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        Toast.makeText(applicationContext,
                            "${items[which]}이 ${if(isChecked) "선택되었습니다." else "선택 해제되었습니다."}",
                        Toast.LENGTH_SHORT).show()
                    }
                })

                setPositiveButton("닫기", null)
                show()
            }
        }
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rootView = inflater.inflate(R.layout.dialog_input, null)
        val customBtn = findViewById<Button>(R.id.customBtn)

        customBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("Input")
                setView(rootView)
                setPositiveButton("닫기",null)
                show()
            }
        }

    }
}