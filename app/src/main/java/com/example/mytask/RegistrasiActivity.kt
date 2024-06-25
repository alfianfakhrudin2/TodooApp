package com.example.mytask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mytask.databinding.ActivityRegistrasiBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest


class RegistrasiActivity : AppCompatActivity() {

    private lateinit var signupButton: Button
    var firebaseAuth = FirebaseAuth.getInstance()

    private lateinit var binding: ActivityRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

//        binding.signupButton.setOnClickListener {
//            if (binding.edtGmail.text.toString().isNotEmpty() && binding.passwordEditTextSignup.text.toString().isNotEmpty() && binding.edtId.text.toString().isNotEmpty()) {
//                processRegister()
//            } else {
//                Toast.makeText(this, "Isi semua kolom", Toast.LENGTH_SHORT).show()
//            }
//        }

        binding.signupButton.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

//    private fun processRegister() {
//        val email = binding.edtGmail.text.toString()
//        val password = binding.passwordEditTextSignup.text.toString()
//        val id = binding.edtId.text.toString()
//
//        // Registrasi ke Firebase
//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // Registrasi sukses
//
//                    val userUpdateProfile  = UserProfileChangeRequest.Builder()
//                        .setDisplayName(id)
//                        .build()
//                    val user = task.result.user
//                    user!!.updateProfile(userUpdateProfile)
//                        .addOnCompleteListener { task ->
//                            if (task.isSuccessful) {
//                                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
//                                startActivity(Intent(this, LoginActivity::class.java))
//                            }
//                        }
//                } else {
//                    // Registrasi gagal
//                    Toast.makeText(this, "Registrasi Gagal", Toast.LENGTH_SHORT).show()
//                }
//            }
//    }
}