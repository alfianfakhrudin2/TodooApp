package com.example.mytask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentHomeBinding
import com.example.mytask.ui.adapter.Horizontal_RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import java.util.Calendar
import java.util.TimeZone


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private fun getClearedUtc(): Calendar {
        val utc: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        utc.clear()
        return utc
    }

//    val datePicker = MaterialDatePicker.Builder.datePicker().build()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        binding.btnOpenDatePicker.setOnClickListener {
//            showDatePicker()
//        }

//        val textView: TextView = binding.myName
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewHorizontal.adapter = Horizontal_RecyclerView()
        binding.btnNotifikasi.setOnClickListener {
            NotificationFragment()
        }
        binding.btnTambahTask.setOnClickListener {
            AddTaskFragment1()
        }
    }

    private fun NotificationFragment() {
        findNavController().navigate(R.id.action_navigation_home_to_notification)
    }
//
//    private fun AddTaskFragment() {
//        findNavController().navigate(R.id.btnTambahTask)
//    }

    private fun AddTaskFragment1() {
        findNavController().navigate(R.id.action_navigation_home_to_add_task)
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