package com.example.mytask.ui.detailChat

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentDetailChatBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailChatFragment : Fragment() {

    private var _binding: FragmentDetailChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.icBackScreen.setOnClickListener {
            findNavController().popBackStack()
        }

        // Hide the bottom navigation bar when this fragment is visible
        hideBottomNav()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        // Show the bottom navigation bar when leaving the fragment
        showBottomNav()
    }

    private fun hideBottomNav() {
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        bottomNav?.visibility = View.GONE
    }

    private fun showBottomNav() {
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        bottomNav?.visibility = View.VISIBLE
    }
}
