package com.majid.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.majid.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // This makes the views defined in activity_main.xml accessible
        setContentView(binding.root)


    }
}