package com.example.task_manager_4.ui.notifications.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.task_manager_4.model.Car
import com.example.task_manager_4.databinding.ItemTaskBinding

class CarAdapter() :
    Adapter<CarAdapter.CarViewHolder>() {
    private val list = arrayListOf<Car>()

    fun setCars(cars: List<Car>) {
        list.clear()
        list.addAll(cars)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.binds(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class CarViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun binds(car: Car) = with(binding) {
            tvTitle.text = car.label
            tvDescription.text = car.model
        }
    }
}