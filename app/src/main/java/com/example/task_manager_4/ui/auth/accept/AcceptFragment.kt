package com.example.task_manager_4.ui.auth.accept

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.task_manager_4.R
import com.example.task_manager_4.databinding.FragmentAcceptBinding
import com.example.task_manager_4.databinding.FragmentTaskBinding
import com.example.task_manager_4.ui.auth.phone.PhoneFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class AcceptFragment : Fragment() {

    private var _binding: FragmentAcceptBinding? = null
    private val binding get() = _binding!!
    private val auth by lazy{ FirebaseAuth.getInstance()}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAcceptBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val verID: String? = arguments?.getString(PhoneFragment.VER_KEY)
        binding.btnAccept.setOnClickListener {
            val credential = PhoneAuthProvider.getCredential(verID.toString(), binding.etCode.enteredCode)
            signInWithPhoneAuthCredential(credential)
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential).addOnSuccessListener {
            findNavController().navigate(R.id.action_acceptFragment_to_navigation_home)
        }.addOnFailureListener{
            Toast.makeText(requireActivity(), it.message,Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}