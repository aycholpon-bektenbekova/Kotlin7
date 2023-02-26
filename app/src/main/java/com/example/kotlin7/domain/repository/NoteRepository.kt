package com.example.kotlin7.domain.repository

import com.example.kotlin7.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun editNote(note: Note)

    fun deleteNote(note: Note)

    fun getNote(): List<Note>
}