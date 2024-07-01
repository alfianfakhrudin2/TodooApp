package com.example.mytask.ui.addFriends

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentAddFriendsBinding

import com.example.mytask.ui.friends.FriendsFragment

class AddFriendsFragment : Fragment() {

    private var _binding: FragmentAddFriendsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddFriendsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddFriendsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBackAddFriends.setOnClickListener {
            FriendsFragment()
        }

        // Di dalam onViewCreated()
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val searchText = s.toString().trim()
                if (searchText.isNotEmpty()) {
                    // Teks tidak kosong, maka tampilkan iv_friends dan btn_logout
                    binding.ivFriends.visibility = View.VISIBLE
                    binding.btnLogout.visibility = View.VISIBLE
                } else {
                    // Teks kosong, maka sembunyikan iv_friends dan btn_logout
                    binding.ivFriends.visibility = View.INVISIBLE
                    binding.btnLogout.visibility = View.INVISIBLE
                }
            }
        })

    }

    private fun FriendsFragment() {
        findNavController().navigate(R.id.navigation_friends)
    }
}