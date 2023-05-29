package com.muradoff.thebestapptask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_TheBestAppTask)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}