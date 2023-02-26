package com.example.kotlin7.domain.usecases

import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.repository.NoteRepository

class DeleteNoteUseCase (
    private val noteRepository: NoteRepository
) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}