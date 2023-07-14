package com.majid.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.majid.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // enabled binding in a module
    // ActivityMainBinding creates a binding class for each XML layout file present in that module.
    private lateinit var binding: ActivityMainBinding

    // Array to store the To-Dos user will input
    val userInputList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // This makes the views defined in activity_main.xml accessible
        // for the UI of this activity
        setContentView(binding.root)

        // Returns a view for userInputList and is used to display in ListView
        val arrayAdapter =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                userInputList
            )

        val userString = binding.userInput.getText()

        // When add Button is clicked by user it will check if the user has entered a valid String
        // If users doesn't enter anything and value is null
        // A toast msg will be displayed to write a To-do
        // If valid input a toast indicating added +String and
        // setAdapter will set the layout
        binding.addButton.setOnClickListener {
            if (!(userString.toString() == "")) {
                Toast.makeText(this, "Added " + userString, Toast.LENGTH_SHORT).show()
                userInputList.add(binding.userInput.getText().toString())
                binding.toDoList.setAdapter(arrayAdapter)
            }else{
                Toast.makeText(this, "Please Write a To-do " + userString, Toast.LENGTH_SHORT).show()

            }
        }

        // Delete a to-do string
        // A toast message will be displayed indicating Deleted +String
        // removeAt func will remove the item from list and
        // setAdapter will set the layout
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