package com.example.mytask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytask.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance()
        auth = Firebase.auth


//        customToken?.let { token ->
//            auth.signInWithCustomToken(token)
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        val user = auth.currentUser
//                        // Lakukan sesuatu setelah login berhasil
//                    } else {
//                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }

        // Implementasi Login
        binding.loginButton.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        // Lakukan sesuatu setelah login berhasil
                            startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }


        binding.txtSignup.setOnClickListener {
            startActivity(Intent(this, RegistrasiActivity::class.java))
        }

//        binding.loginButton.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//        }
    }
}