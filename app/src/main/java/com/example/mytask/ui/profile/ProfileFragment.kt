package com.example.mytask.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mytask.LoginActivity
import com.example.mytask.R


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Implementasi ketika tombol di klik
        view.findViewById<Button>(R.id.btn_logout).setOnClickListener {
            // Membuat Intent untuk berpindah ke Activity
            val intent = Intent(activity, LoginActivity::class.java)

            // (Opsional) Mengirim data menggunakan Intent
            intent.putExtra("key", "value")

            // Memulai Activity baru
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }
}