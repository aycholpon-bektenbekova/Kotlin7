package com.example.kotlin7.presentation.viewmodel

import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.usecases.CreateNoteUseCase
import com.example.kotlin7.presentation.base.BaseViewModel
import com.example.kotlin7.presentation.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CreateViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
) : BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun createNotes(note: Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }
}