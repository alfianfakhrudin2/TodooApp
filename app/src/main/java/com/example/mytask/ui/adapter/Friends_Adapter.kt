package com.example.mytask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytask.databinding.ItemProfileBinding
import com.example.mytask.ui.model.modelFriends

class Friends_Adapter(
    private val context: Context,
    private val itemList: ArrayList<modelFriends>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<Friends_Adapter.ListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: modelFriends)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemList.size

    inner class ListViewHolder(private val binding: ItemProfileBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: modelFriends) {
            binding.apply {
                ivProfileFriends.setImageResource(item.photo)
                tvTitle.text = item.title
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(itemList[position])
            }
        }
    }
}
