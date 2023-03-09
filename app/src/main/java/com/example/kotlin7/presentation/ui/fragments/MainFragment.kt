package com.example.kotlin7.presentation.ui.fragments

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin7.R
import com.example.kotlin7.databinding.FragmentMainBinding
import com.example.kotlin7.presentation.base.BaseFragment
import com.example.kotlin7.presentation.ui.fragments.adapter.MainFragmentAdapter
import com.example.kotlin7.presentation.utils.UIState
import com.example.kotlin7.presentation.viewmodel.MainViewModel

class MainFragment() : BaseFragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels<MainViewModel> ()
    private val adapter = MainFragmentAdapter()
    private val binding by viewBinding(FragmentMainBinding::bind)


    override fun initialize() {
        setUpRV()
    }

    override fun setUpRequests() {
        viewModel.getNotes()
    }

    override fun setUpSubscribers() {
        viewModel.getNotesState.collectUIState(
           state = {state ->
                   binding.progressBar.isVisible = state is UIState.Loading
           },
            onSuccess = {
                adapter.addAllNotes(it)
            }
        )
    }

    override fun initClickListeners() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }
    }

    private fun setUpRV() {
        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = adapter
        }
    }
}