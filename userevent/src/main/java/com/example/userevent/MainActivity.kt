package com.example.userevent

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

//        when (event?.action) {
//            MotionEvent.ACTION_DOWN -> {
//                Toast.makeText(this,"Touch down event - x: ${event.x} | y: ${event.y} \n" +
//                        "rawX: ${event.rawX} | rawY: ${event.rawY}", Toast.LENGTH_SHORT).show()
//            }
//            MotionEvent.ACTION_UP -> {
//                Toast.makeText(this,"Touch up event!!!!", Toast.LENGTH_SHORT).show()
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Toast.makeText(this,"Touch move event - x: ${event.x} | y: ${event.y}", Toast.LENGTH_SHORT).show()
//            }
//
//        }

        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("test",keyCode.toString());
        when(keyCode) {
            KeyEvent.KEYCODE_0 -> Toast.makeText(this,"0키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_1 -> Toast.makeText(this,"1키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_2 -> Toast.makeText(this,"2키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_3 -> Toast.makeText(this,"3키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_A -> Toast.makeText(this,"A키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_S -> Toast.makeText(this,"S키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_VOLUME_UP -> Toast.makeText(this,"볼륨Up키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_VOLUME_DOWN -> Toast.makeText(this,"볼륨Down키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_BACK -> Toast.makeText(this,"뒤로 가기 키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_HOME -> Toast.makeText(this,"홈 키가 눌러졌어요", Toast.LENGTH_SHORT).show()
            KeyEvent.KEYCODE_POWER -> Toast.makeText(this,"전원 버튼이 눌러졌어요", Toast.LENGTH_SHORT).show()

        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {

        Toast.makeText(this,"Key up event", Toast.LENGTH_SHORT).show()
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("test","${keyCode}가 길게 눌러졌습니다~")
        return super.onKeyLongPress(keyCode, event)
    }
}
