package com.example.mytask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytask.databinding.FragmentHomeBinding
import com.example.mytask.ui.adapter.Horizontal_RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import com.google.android.material.snackbar.Snackbar
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

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        val textView: TextView = binding.myName
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    private fun showDatePicker() {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Select Date")

        val picker = builder.build()

        picker.addOnPositiveButtonClickListener(
            MaterialPickerOnPositiveButtonClickListener { selection ->
                // Handle the selected date
                val selectedDate = picker.headerText
                // Do something with the selected date
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewHorizontal.adapter = Horizontal_RecyclerView()

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