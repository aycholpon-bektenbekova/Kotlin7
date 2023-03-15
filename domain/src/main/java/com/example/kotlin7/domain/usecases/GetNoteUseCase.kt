package com.example.kotlin7.domain.usecases

import com.example.kotlin7.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke() = noteRepository.getNote()
}