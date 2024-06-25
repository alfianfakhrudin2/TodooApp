package com.example.mytask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytask.R
import com.example.mytask.databinding.ItemNotifikasiBinding
import com.example.mytask.ui.adapter.Friends_Adapter.OnItemClickListener
import com.example.mytask.ui.model.modelFriends
import com.example.mytask.ui.model.modelNotifikasi

class Notifikasi_Adapter(
    private val context: Context,
    private val itemList: ArrayList<modelNotifikasi>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<Notifikasi_Adapter.ListViewHolder>(){

    interface OnItemClickListener {
        fun onItemClick(item: modelNotifikasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemNotifikasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemList.size


    inner class ListViewHolder(private val binding: ItemNotifikasiBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }
        fun bind(item: modelNotifikasi){
            // Bind data
            binding.apply {
                tvTitle.text = item.title
            }
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(itemList[position])
            }
        }
    }

}