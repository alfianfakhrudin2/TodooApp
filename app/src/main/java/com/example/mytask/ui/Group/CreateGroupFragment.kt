package com.example.mytask.ui.Group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentCreateGroupBinding
import com.example.mytask.databinding.FragmentFriendsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class CreateGroupFragment : Fragment() {
    private var _binding: FragmentCreateGroupBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateGroupBinding.inflate(inflater, container, false)
        return binding.root
//        binding.ivBack.setOnClickListener {
//            findNavController().popBackStack()
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
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