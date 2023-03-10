package com.example.kotlin7.presentation.ui.fragments

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin7.R
import com.example.kotlin7.databinding.FragmentCreateNoteBinding
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.presentation.base.BaseFragment
import com.example.kotlin7.presentation.utils.UIState
import com.example.kotlin7.presentation.viewmodel.CreateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : BaseFragment(R.layout.fragment_create_note) {

    private val viewModel: CreateViewModel by viewModels()
    private val binding by viewBinding(FragmentCreateNoteBinding::bind)

    override fun setUpSubscribers() {
        viewModel.createNoteState.collectUIState(
            state = {state ->
                    binding.progressBar.isVisible = state is UIState.Loading
            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }

    override fun initClickListeners() {
        binding.fabSave.setOnClickListener {
            createNote()
        }
    }


    private fun createNote() {
        viewModel.createNotes(
            Note (
               title = binding.tvTitle.text.toString(),
                description = binding.tvDesc.text.toString(),
                createdAt = Long.MAX_VALUE
            )
        )
    }
}