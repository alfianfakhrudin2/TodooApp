package com.example.mytask.ui.addTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentAddTaskBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import java.text.SimpleDateFormat
import java.util.*

class AddTaskFragment : Fragment() {
    private var _binding: FragmentAddTaskBinding? = null
    private val binding get() = _binding!!

    private lateinit var tvSelectedDate: TextView
    private lateinit var btnSelectDate: ImageButton
    private lateinit var autoCompleteTextView: MaterialAutoCompleteTextView
    private lateinit var tvSelectedItem: TextView
    private lateinit var btnAddTask: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views using binding
        tvSelectedDate = binding.tvSelectedDate
        btnSelectDate = binding.btnSelectDate
        autoCompleteTextView = binding.autoCompleteTextView as MaterialAutoCompleteTextView
        tvSelectedItem = binding.textView8
        btnAddTask = binding.btnAddTask

        // Set up the date picker button click listener
        btnSelectDate.setOnClickListener {
            showDatePickerDialog()
        }

        // Set up the dropdown menu (MaterialAutoCompleteTextView)
        setupDropdownMenu()

        // Set up the "Add Task" button click listener
        btnAddTask.setOnClickListener {
            showSuccessAlertDialog()
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select a date")
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val selectedDate = Date(selection)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            tvSelectedDate.text = dateFormat.format(selectedDate)
        }

        datePicker.show(parentFragmentManager, "DatePicker")
    }

    private fun setupDropdownMenu() {
        // Define the options for the dropdown menu
        val options = resources.getStringArray(R.array.language) // Assuming you have defined this array in strings.xml

        // Create an ArrayAdapter with the options
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            options
        )

        // Set the adapter to the MaterialAutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter)

        // Set the listener for when an item is selected
        autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            tvSelectedItem.text = selectedItem
        }
    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = LayoutInflater.from(requireContext())
        val view: View = inflater.inflate(R.layout.sukses_ulasan_mentor_dialog, null)

        // Menentukan lebar dan tinggi dialog
        val width = resources.displayMetrics.widthPixels * 0.8 // Misalnya, 80% dari lebar layar
        val height = WindowManager.LayoutParams.WRAP_CONTENT // Tinggi sesuai dengan konten

        builder.setView(view)

        val alertDialog = builder.create()

        // Mengatur lebar dan tinggi dialog
        alertDialog.window?.setLayout(width.toInt(), height)

        alertDialog.setCanceledOnTouchOutside(false)

        val btnLanjutkanLogin = view.findViewById<Button>(R.id.kembali_button)

        btnLanjutkanLogin.setOnClickListener {
            alertDialog.dismiss()
            // Navigate to TaskFragment using NavController
            findNavController().navigate(R.id.navigation_task)
        }

        alertDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
