package com.example.mytask.ui.task

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentTaskBinding
import com.example.mytask.ui.adapter.Friends_Adapter
import com.example.mytask.ui.adapter.Task_Adapter
import com.example.mytask.ui.chat.ChatFragment

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

//    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
//        val textView: TextView = binding.textTask
//        taskViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        binding.rvTask.adapter = Task_Adapter()

        binding.btnTask.setOnClickListener {
            addTaskFragment()
        }
        binding.btnHistory.setOnClickListener {
            HistoryFragment()
        }
        binding.btnChat.setOnClickListener {
            ChatFragment()
        }

    }

    private fun addTaskFragment() {
        findNavController().navigate(R.id.action_navigation_task_to_addTaskFragment)
    }

    private fun HistoryFragment() {
        findNavController().navigate(R.id.action_navigation_task_to_historyFragment)
    }

    private fun ChatFragment() {
        findNavController().navigate(R.id.navigation_chatFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

}