package com.example.kotlin7.presentation.ui.fragments

import android.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin7.R
import com.example.kotlin7.databinding.FragmentMainBinding
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.presentation.base.BaseFragment
import com.example.kotlin7.presentation.ui.fragments.adapter.NoteListAdapter
import com.example.kotlin7.presentation.utils.UIState
import com.example.kotlin7.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val listAdapter = NoteListAdapter(
        this::onItemClick,
        this::onItemLongClick
    )
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
            onSuccess = {data ->
               listAdapter.submitList(data)
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
            adapter = listAdapter
        }
    }

    private fun onItemClick(note: Note) {
        findNavController().navigate(R.id.createNoteFragment, bundleOf("editNote" to note))
    }
    private fun onItemLongClick(note: Note) {
        fun deleteAlertDialog(note: Note) {
            val alertDialogBuilder = AlertDialog.Builder(context)
            alertDialogBuilder.setMessage("удалить заметку?")
            alertDialogBuilder.setPositiveButton("да") { _, _ ->
                viewModel.deleteNote(note)
                activity?.recreate()
            }
            alertDialogBuilder.setNegativeButton("нет") { dialog, _ ->
                dialog.dismiss()
            }
            alertDialogBuilder.show()
        }
    }
}