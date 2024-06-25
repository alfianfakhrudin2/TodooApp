package com.example.mytask.ui.notification

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytask.R
import com.example.mytask.databinding.FragmentNotificationBinding
import com.example.mytask.ui.adapter.Friends_Adapter
import com.example.mytask.ui.adapter.Notifikasi_Adapter
import com.example.mytask.ui.home.HomeFragment
import com.example.mytask.ui.model.modelFriends
import com.example.mytask.ui.model.modelNotifikasi


class NotificationFragment : Fragment() {

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNotification.adapter = Notifikasi_Adapter( requireActivity(), getListNotifikasi(), object : Notifikasi_Adapter.OnItemClickListener {
            override fun onItemClick(item: modelNotifikasi) {
                // Handle item click
                // For example, navigate to a detailed view of the friend
            }
        })

        binding.BtnBack.setOnClickListener {
            HomeFragment()
        }

    }

    private fun getListNotifikasi(): ArrayList<modelNotifikasi> {
        val dataTitles = resources.getStringArray(R.array.desc_notifikasi)

        val listNotification = ArrayList<modelNotifikasi>()
        for (i in dataTitles.indices) {
            val kursus = modelNotifikasi(
                dataTitles[i],
            )
            listNotification.add(kursus)
        }
        // Recycle the typed array
        return listNotification
    }

    private fun HomeFragment() {
        findNavController().popBackStack()
    }

    private val viewModel: NotificationViewModel by viewModels()

}