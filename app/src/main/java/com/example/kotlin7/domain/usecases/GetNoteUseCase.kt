package com.example.kotlin7.domain.usecases

import com.example.kotlin7.domain.repository.NoteRepository

class GetNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun getNote() = noteRepository.getNote()
}