package com.example.kotlin7.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.usecases.GetNoteUseCase
import com.example.kotlin7.domain.utils.Resource
import com.example.kotlin7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotesUseCase: GetNoteUseCase
): ViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNotesState = _getNotesState.asStateFlow()

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            getNotesUseCase.getNote().collect() { res ->
                when (res) {
                    is Resource.Error -> {
                        _getNotesState.value = UIState.Error(res.message!!)
                    }
                    is Resource.Loading -> {
                        _getNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (res.data != null) {
                            _getNotesState.value = UIState.Success(res.data)
                        }
                    }
                }
            }
        }
    }
}