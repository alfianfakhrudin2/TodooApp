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
import com.example.mytask.ui.model.modelTask
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.ArrayList

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

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

        val taskAdapter = Task_Adapter(requireActivity(), getListTask(), object : Task_Adapter.OnItemClickListener {
            override fun onItemClick(item: modelTask) {}
        })

        binding.rvTask.adapter = taskAdapter

        binding.btnTask.setOnClickListener {
            addTaskFragment()
        }
        binding.btnHistory.setOnClickListener {
            HistoryFragment()
        }
        binding.btnChat.setOnClickListener {
            ChatFragment()
        }

        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        bottomNav?.visibility = View.VISIBLE

    }

    private fun getListTask(): ArrayList<modelTask> {
        val dataTitles = resources.getStringArray(R.array.title_task)
        val dataDesc = resources.getStringArray(R.array.desc_task)
        val dataStatus = resources.getStringArray(R.array.presentes_task)


        val listNotification = ArrayList<modelTask>()
        for (i in dataTitles.indices) {
            val kursus = modelTask(
                dataTitles[i],
                dataDesc[i],
                dataStatus[i],
            )
            listNotification.add(kursus)
        }
        return listNotification
    }

    private fun addTaskFragment() {
        findNavController().navigate(R.id.action_navigation_task_to_addTaskFragment)
    }

    private fun HistoryFragment() {
        findNavController().navigate(R.id.action_navigation_task_to_historyFragment)
    }

    private fun ChatFragment() {
        findNavController().navigate(R.id.action_navigation_task_to_chatFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}