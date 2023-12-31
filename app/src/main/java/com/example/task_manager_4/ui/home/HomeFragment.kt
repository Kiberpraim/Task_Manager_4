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
    private val binding get() = _binding!!
    private val adapter = TaskAdapter(this::onLongClickTask, this::onClickTask)

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
        getTasksList()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter = adapter
    }

    private fun onClickTask(bundle: Bundle) {
        findNavController().navigate(R.id.taskFragment, bundle)
    }

    private fun onLongClickTask(task: Task) {
        val dialogBuilder = AlertDialog.Builder(requireActivity())
        dialogBuilder.setTitle(getString(R.string.you_wont_delete))
            .setMessage(getString(R.string.recovery_is_not_possible))
            .setPositiveButton(getString(R.string.ok)) { dialog: DialogInterface, _: Int ->
                // Обработка нажатия кнопки "OK"
                App.db.taskDao().delete(task)
                getTasksList()
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog: DialogInterface, _: Int ->
                // Обработка нажатия кнопки "Отмена"
                dialog.dismiss()
            }
        dialogBuilder.show()
    }

    private fun getTasksList() {
        val list = App.db.taskDao().getAll()
        adapter.setTasks(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}