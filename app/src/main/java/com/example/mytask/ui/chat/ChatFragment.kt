package com.example.mytask.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentChatBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.constraintLayout.setOnClickListener {
            findNavController().navigate(R.id.navigationDetailchatFragment)
        }
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        bottomNav?.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        // Show the bottom navigation bar when leaving the fragment
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        bottomNav?.visibility = View.VISIBLE
    }

}