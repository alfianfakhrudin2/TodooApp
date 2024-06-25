package com.example.mytask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytask.R
import com.example.mytask.databinding.ItemTaskBinding
import com.example.mytask.ui.adapter.Notifikasi_Adapter.OnItemClickListener
import com.example.mytask.ui.model.modelNotifikasi
import com.example.mytask.ui.model.modelTask

class Task_Adapter(
    private val context: Context,
    private val itemList: ArrayList<modelTask>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<Task_Adapter.ListViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(item: modelTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(item = itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class ListViewHolder(private val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {


        fun bind(item: modelTask) {

            // Bind data
            binding.apply{
                tvTitle.text = item.title
                tvDesc.text = item.description
                tvPresentase.text = item.status
            }
        }

        override fun onClick(p0: View?) {
        }

    }
}