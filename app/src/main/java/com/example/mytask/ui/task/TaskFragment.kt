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
import com.example.mytask.R
import com.example.mytask.databinding.FragmentTaskBinding

import com.example.mytask.ui.addTask.AddTaskFragment

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(TaskViewModel::class.java)

        binding = FragmentTaskBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView = binding.textTask
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnTask.setOnClickListener {
            // Panggil fungsi untuk berpindah ke AddTaskFragment
            navigateToAddTaskFragment()
        }

        return root
    }

    private fun navigateToAddTaskFragment() {
        // Buat instance dari AddTaskFragment
        val addTaskFragment = AddTaskFragment()

        // Mulai transaksi fragment
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        // Ganti containerFragment dengan id dari container tempat AddTaskFragment akan ditampilkan
        transaction.replace(R.id.container, addTaskFragment)

        // (Opsional) Tambahkan ke back stack, sehingga dapat kembali ke TaskFragment jika diperlukan
        transaction.addToBackStack(null)

        // Jalankan transaksi
        transaction.commit()
    }
}