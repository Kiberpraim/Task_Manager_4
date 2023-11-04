package com.example.task_manager_4.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.task_manager_4.databinding.ItemOnboardingBinding
import com.example.task_manager_4.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = listOf(
        OnBoarding(
            "Task Manager",
            "Ваш ежедневный планировщик",
            "https://play-lh.googleusercontent.com/5yH7sL-TThjIRsz8zVwO86bleZkgJ9wbbomQp_2ukOC5iUFYNToVkfsRRR7jYAvcddU=w2560-h1440-rw"
        ),
        OnBoarding(
            "Удобный",
            "Пока на разработке ))",
            "https://play-lh.googleusercontent.com/w4sjqgBsdU1fbNboYxGAGJPLj-aum9dnjOiPSR-nO7tWj4HynzkL4EHsYGF0d1aXR1uS=w2560-h1440-rw"
        ),
        OnBoarding(
            "Темный режим",
            "Тоже на разработке ))",
            "https://play-lh.googleusercontent.com/MDDBjefxVNUZJ7yXdEwwKoBKYbFPUNNzMfgEbjei7aRIU82cP2WQ2FsqsSTbA_9kkuw=w2560-h1440-rw"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) : ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDescription.text = onBoarding.description
            Glide.with(binding.imageOnBoarding).load(onBoarding.image).into(binding.imageOnBoarding)
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }
}