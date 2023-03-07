package com.example.kotlin7.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin7.data.mappers.toNoteEntity
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.usecases.CreateNoteUseCase
import com.example.kotlin7.domain.utils.Resource
import com.example.kotlin7.presentation.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
) : ViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Note>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun createNotes() {

        viewModelScope.launch(Dispatchers.IO) {
            createNoteUseCase.createNote(note = ).collect() { res ->
                when(res) {
                    is Resource.Error -> {
                        _createNoteState.value = UIState.Error(res.message!!)
                    }
                    is Resource.Loading -> {
                        _createNoteState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                       // if (res.data != null) {
                        //    _createNoteState.value = UIState.Success(res.data)
                        //}
                    }
                }

            }
        }
    }
}