package com.example.mytask.ui.Group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentNewGroupBinding
import com.example.mytask.ui.adapter.Friends_Adapter
import com.example.mytask.ui.model.modelFriends
import com.google.android.material.bottomnavigation.BottomNavigationView


class newGroupFragment : Fragment() {
    private var _binding: FragmentNewGroupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friendsAdapter = Friends_Adapter(requireActivity(), getListFriends(), object : Friends_Adapter.OnItemClickListener {
            override fun onItemClick(item: modelFriends) {
                // Handle item click
                // For example, navigate to a detailed view of the friend
            }
        })

        binding.rvfriends.adapter = friendsAdapter

        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.fabAdd.setOnClickListener {
            startCreateGroup()
        }

        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        bottomNav?.visibility = View.GONE
    }

    private fun startCreateGroup() {
        findNavController().navigate(R.id.navigation_create_group)
    }

    private fun getListFriends(): ArrayList<modelFriends> {
        val dataPhotos = resources.obtainTypedArray(R.array.data_photo_friends)
        val dataTitles = resources.getStringArray(R.array.name_friends)

        val listKursus = ArrayList<modelFriends>()
        for (i in dataTitles.indices) {
            val kursus = modelFriends(
                dataPhotos.getResourceId(i, -1),
                dataTitles[i],
            )
            listKursus.add(kursus)
        }
        // Recycle the typed array
        dataPhotos.recycle()
        return listKursus
    }

}