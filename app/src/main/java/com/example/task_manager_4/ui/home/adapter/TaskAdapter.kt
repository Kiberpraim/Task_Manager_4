package com.example.task_manager_4.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.task_manager_4.databinding.ItemTaskBinding
import com.example.task_manager_4.model.Task

class TaskAdapter(private val onLongClickTask: (Task) -> Unit) :
    Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()

    fun addTask(task: Task) {
        list.add(0, task)
        notifyDataSetChanged()
    }

    fun setTasks(tasks: List<Task>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binds(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun binds(task: Task) = with(binding) {
            tvTitle.text = task.title
            tvDescription.text = task.description
            itemView.setOnLongClickListener {
                onLongClickTask(task)
                false
            }
        }

    }
}
