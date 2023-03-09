package com.example.kotlin7.presentation.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin7.databinding.FragmentMainBinding
import com.example.kotlin7.domain.model.Note

class MainFragmentAdapter: RecyclerView.Adapter<MainFragmentAdapter.MainFragmentViewHolder>() {

    private var notes = arrayListOf<Note>()

    fun addAllNotes(list: List<Note>) {
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentViewHolder {
        return MainFragmentViewHolder(FragmentMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = notes.size

    inner class MainFragmentViewHolder(private val binding: FragmentMainBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val task = notes[adapterPosition]

            binding.rvNotes.adapter = this@MainFragmentAdapter
        }
    }
}