package com.example.kotlin7.domain.usecases

import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.repository.NoteRepository

class EditNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}