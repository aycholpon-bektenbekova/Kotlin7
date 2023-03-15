package com.example.kotlin7.presentation.viewmodel

import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.usecases.DeleteNoteUseCase
import com.example.kotlin7.domain.usecases.GetNoteUseCase
import com.example.kotlin7.presentation.base.BaseViewModel
import com.example.kotlin7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotesUseCase: GetNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): BaseViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNotesState = _getNotesState.asStateFlow()

    fun getNotes() {
        getNotesUseCase().collectFlow(_getNotesState)
    }

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _deleteNoteState.asStateFlow()

    fun deleteNote(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }
}