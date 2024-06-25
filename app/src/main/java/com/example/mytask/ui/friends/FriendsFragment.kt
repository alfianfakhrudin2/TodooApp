package com.example.mytask.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentFriendsBinding
import com.example.mytask.ui.adapter.Friends_Adapter
import com.example.mytask.ui.model.modelFriends

class FriendsFragment : Fragment() {

    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView adapter
        val friendsAdapter = Friends_Adapter(requireActivity(), getListFriends(), object : Friends_Adapter.OnItemClickListener {
            override fun onItemClick(item: modelFriends) {
                // Handle item click
                // For example, navigate to a detailed view of the friend
            }
        })
        binding.rvfriends.adapter = friendsAdapter

        // Handle Add Friends button click
        binding.btnAddFriends.setOnClickListener {
            addFriendsFragment()
        }

        // Handle Add Group button click
        binding.btnAddGroup.setOnClickListener {
            startNewGroupFragment()
        }
    }

    private fun getListFriends(): ArrayList<modelFriends> {
        val dataPhotos = resources.obtainTypedArray(R.array.data_photo_friends)
        val dataTitles = resources.getStringArray(R.array.name_friends)

        val listFriends = ArrayList<modelFriends>()
        for (i in dataTitles.indices) {
            val kursus = modelFriends(
                dataPhotos.getResourceId(i, -1),
                dataTitles[i],
            )
            listFriends.add(kursus)
        }
        // Recycle the typed array
        dataPhotos.recycle()
        return listFriends
    }

    private fun addFriendsFragment() {
        findNavController().navigate(R.id.addFriendsFragment)
    }

    private fun startNewGroupFragment() {
        findNavController().navigate(R.id.navigation_new_group)
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
