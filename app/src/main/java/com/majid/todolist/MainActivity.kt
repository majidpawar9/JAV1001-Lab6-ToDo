package com.majid.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.majid.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val userInputList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // This makes the views defined in activity_main.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        val arrayAdapter =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                userInputList
            )

        val userString = binding.userInput.getText()

        binding.addButton.setOnClickListener {
            if (!(userString.toString() == "")) {
                Toast.makeText(this, "Added " + userString, Toast.LENGTH_SHORT).show()
                userInputList.add(binding.userInput.getText().toString())
                binding.toDoList.setAdapter(arrayAdapter)
            }else{
                Toast.makeText(this, "Please Write a To-do " + userString, Toast.LENGTH_SHORT).show()

            }
        }

        binding.toDoList.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { adapterView: AdapterView<*>, view2: View, i: Int, l: Long ->
                Toast.makeText(
                    applicationContext,
                    "Deleted " + userInputList.get(i),
                    Toast.LENGTH_SHORT
                ).show()
                userInputList.removeAt(i)
                binding.toDoList.setAdapter(arrayAdapter)
                true
            }

    }
}