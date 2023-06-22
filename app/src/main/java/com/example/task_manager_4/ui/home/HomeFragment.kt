package com.example.task_manager_4.ui.home

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task_manager_4.App
import com.example.task_manager_4.R
import com.example.task_manager_4.databinding.FragmentHomeBinding
import com.example.task_manager_4.model.Task
import com.example.task_manager_4.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val adapter = TaskAdapter(this::onLongClickTask)
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
        remakeTasksList()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }

        binding.recyclerView.adapter = adapter
    }

    private fun onLongClickTask(task: Task){
        val dialogBuilder = AlertDialog.Builder(requireActivity())

        dialogBuilder.setTitle("Вы хотите удилить?")
            .setMessage("Если вы удалите \"${task.title}\" то востановлени будет невозможным.")
            .setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
                // Обработка нажатия кнопки "OK"
                App.db.taskDao().delete(task)
                remakeTasksList()
                dialog.dismiss()
            }
            .setNegativeButton("Отмена"){ dialog: DialogInterface, _: Int ->
                // Обработка нажатия кнопки "Отмена"
                dialog.dismiss()
            }
        dialogBuilder.show()
    }

    private fun remakeTasksList(){
        val list = App.db.taskDao().getAll()
        adapter.setTasks(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}