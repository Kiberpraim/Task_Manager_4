package com.example.task_manager_4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
<<<<<<< HEAD
=======
import androidx.fragment.app.setFragmentResultListener
>>>>>>> 8decab1 (Initial commit)
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.task_manager_4.R
import com.example.task_manager_4.databinding.FragmentHomeBinding
<<<<<<< HEAD
=======
import com.example.task_manager_4.model.Task
import com.example.task_manager_4.ui.home.adapter.TaskAdapter
import com.example.task_manager_4.ui.task.TaskFragment
>>>>>>> 8decab1 (Initial commit)

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
<<<<<<< HEAD

    // This property is only valid between onCreateView and
    // onDestroyView.
=======
    private val adapter = TaskAdapter()
>>>>>>> 8decab1 (Initial commit)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
=======
        setFragmentResultListener(TaskFragment.TASK_REQUEST) { _, bundle ->
            val data = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.addTask(data)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter = adapter
>>>>>>> 8decab1 (Initial commit)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}