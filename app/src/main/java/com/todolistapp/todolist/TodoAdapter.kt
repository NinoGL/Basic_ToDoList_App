package com.todolistapp.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) /* It contains
    each View of the list*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        /*This method sets de Data in each specific View of our Recycle View*/
        holder.itemView.apply {
            var tvTitle = findViewById<TextView>(R.id.tvTitle)
            var cbDone = findViewById<CheckBox>(R.id.cbDone)
            tvTitle.text = todos[position]. title
            cbDone.isChecked = todos[position].isChecked
        }
    }
}