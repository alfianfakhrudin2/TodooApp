package com.example.mytask.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytask.databinding.FragmentFriendsBinding


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
        val notificationsViewModel =
            ViewModelProvider(this).get(FriendsViewModel::class.java)

        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.myName
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
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