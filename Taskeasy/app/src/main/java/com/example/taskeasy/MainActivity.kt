package com.example.taskeasy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val tasks = mutableListOf<Task>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val inputTask = findViewById<EditText>(R.id.inputTask)
        val addButton = findViewById<Button>(R.id.addButton)

        adapter = TaskAdapter(tasks,
            onDelete = { position ->
                tasks.removeAt(position)
                adapter.notifyItemRemoved(position)
            },
            onComplete = { position ->
                tasks[position].isComplete = !tasks[position].isComplete
                adapter.notifyItemChanged(position)
            })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val taskText = inputTask.text.toString()
            if (taskText.isNotEmpty()) {
                tasks.add(Task(taskText))
                adapter.notifyItemInserted(tasks.size - 1)
                inputTask.text.clear()
            }
        }
    }
}
