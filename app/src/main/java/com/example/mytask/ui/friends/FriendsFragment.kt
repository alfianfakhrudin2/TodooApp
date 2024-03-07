package com.example.mytask.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentFriendsBinding


import com.example.mytask.ui.adapter.Friends_Adapter
import com.example.mytask.ui.adapter.Horizontal_RecyclerView


class FriendsFragment : Fragment() {

    private var _binding: FragmentFriendsBinding? = null

//     This property is only valid between onCreateView and
//     onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val FriendsViewModel =
            ViewModelProvider(this).get(FriendsViewModel::class.java)

        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.myName
        FriendsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvfriends.adapter = Friends_Adapter()

        binding.btnAddFriends.setOnClickListener {
            addFriendsFragment()
        }
    }

    private fun addFriendsFragment() {
        findNavController().navigate(R.id.addFriendsFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}