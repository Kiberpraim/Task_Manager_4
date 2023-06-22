package com.example.task_manager_4.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.task_manager_4.App
import com.example.task_manager_4.R
import com.example.task_manager_4.databinding.FragmentProfileBinding
import com.example.task_manager_4.databinding.FragmentTaskUpdateBinding
import com.example.task_manager_4.model.Task

class TaskUpdateFragment : Fragment() {

    private var _binding: FragmentTaskUpdateBinding? = null
    private val binding get() = _binding!!
    lateinit var task: Task

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receivedBundle = arguments
        task = receivedBundle!!.getSerializable("TASK") as Task

        binding.etTitleUpdate.setText(task.title)
        binding.etDescriptionUpdate.setText(task.description)

        binding.btnUpdate.setOnClickListener {
            onUpdate()
        }
    }

    private fun onUpdate() {
        val data = Task(
            id = task.id,
            title = binding.etTitleUpdate.text.toString(),
            description = binding.etDescriptionUpdate.text.toString()
        )
        App.db.taskDao().update(data)
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}