package com.example.task_manager_4.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.task_manager_4.model.Car
import com.example.task_manager_4.databinding.FragmentDashboardBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            setData()
        }
    }

    private fun setData() {
        val data= Car(
            label = binding.etLabel.text.toString(),
            model = binding.etModel.text.toString()
        )
        db.collection(Firebase.auth.currentUser?.uid.toString())
            .document()
            .set(data)
            .addOnSuccessListener {
                Toast. makeText(requireContext(),"Успешно сохранено!",Toast.LENGTH_SHORT).show()
                binding.etLabel.text.clear()
                binding.etModel.text.clear()
            }.addOnFailureListener {
                Toast. makeText(requireContext(),"Ошибка: "+ it ,Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}