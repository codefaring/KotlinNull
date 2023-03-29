package com.example.kotlinnull

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinnull.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var nullSafety: NullSafety
        if (1 > 2) {
            nullSafety = NullSafety()
        }
//        nullSafety.print() 에러발생으로 실행 불가

        var inputNull: String? = null
        var notNull = "kotlin"
        Log.d("inputNull","$inputNull")
//        var notInputNull: String = null    // 널을 할당할 수 없음.


        // null 체크를 해야지 파라미터로 null 받을 수 있음.
        fun nullPara(str: String?) {
            if(str != null) {
                Log.d("nullPara-if","${str.length}")
            } else Log.d("nullPara-else","Null이 들어왔어요!")
        }
        nullPara(inputNull)
        nullPara(notNull)

        fun nullReturn(): String? {
            return null
        }
        Log.d("nullReturn","${nullReturn()}")

        fun testSafeCall(str: String?): Int? {
            // ?. -> 세이프콜이라고 부름. str이 널이면 length 건너뜀
            var resultNull: Int? = str?.length
            return resultNull
        }
        Log.d("testSafeCall", "${inputNull}")

        val showUp = ActivityMainBinding.inflate(layoutInflater)
        setContentView(showUp.root)

        showUp.btn.setOnClickListener{
            showUp.textView.text = "Kotlin의 문자길이는 ${testSafeCall(notNull)}입니다"
        }
    }
}

class NullSafety {
    fun print() {
        Log.d("nullSafety", "")
    }
}