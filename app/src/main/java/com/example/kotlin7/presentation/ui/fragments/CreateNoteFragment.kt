package com.example.kotlin7.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kotlin7.databinding.FragmentCreateNoteBinding
import com.example.kotlin7.presentation.utils.UIState
import com.example.kotlin7.presentation.viewmodel.CreateViewModel
import kotlinx.coroutines.launch

class CreateNoteFragment : Fragment() {

    private val viewModel: CreateViewModel by viewModels<CreateViewModel> ()
    private lateinit var binding:FragmentCreateNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRequests()
        setUpSubscribers()
    }

    private fun setUpSubscribers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.createNoteState.collect{ state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                           //progress bar
                        }
                        is UIState.Success -> {
                            //adapter
                        }
                    }

                }
            }
        }
    }

    private fun setUpRequests() {
        viewModel.createNotes()
    }


}