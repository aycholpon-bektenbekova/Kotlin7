package com.example.kotlin7.presentation.ui.fragments.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin7.databinding.ItemNoteBinding
import com.example.kotlin7.domain.model.Note

class NoteListAdapter(
    private val onItemClick: (Note) -> Unit,
    private val onItemLongClick: (Note) -> Unit
): ListAdapter<Note, NoteListAdapter.ListViewHolder>(
    NoteDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ListViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.title.text = note.title

            itemView.setOnClickListener {
                onItemClick.invoke(note)
            }

            itemView.setOnLongClickListener{
                onItemLongClick.invoke(note)
                true
            }
        }
    }

    private class NoteDiffUtil: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
    }
}