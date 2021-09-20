package com.todolistapp.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todolistapp.todolist.R.id.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Terminar TP", false),
            Todo("Ir al super", true),
            Todo("Sacar turnos", false),
            Todo("Salir a correr", false),
        )

        val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        val btnAddTodo = findViewById<Button>(btnAddToDO)
        val etToDo = findViewById<EditText>(R.id.etToDo)

        rvTodos.adapter = adapter // Setting the RV adapter
        rvTodos.layoutManager = LinearLayoutManager(this) //Recycle View Layout type

        btnAddTodo.setOnClickListener{
            val title = etToDo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
        }



    }
}