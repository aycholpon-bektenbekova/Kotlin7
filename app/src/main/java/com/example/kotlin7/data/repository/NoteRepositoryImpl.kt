package com.example.kotlin7.data.repository

import com.example.kotlin7.data.local.NoteDao
import com.example.kotlin7.data.mappers.toNote
import com.example.kotlin7.data.mappers.toNoteEntity
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
):NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(toNoteEntity(note))
    }

    override fun editNote(note: Note) {
      noteDao.editNote(toNoteEntity(note))
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(toNoteEntity(note))
    }

    override fun getNote(): List<Note> {
        return noteDao.getNote().map {
            toNote(it)
        }
    }
}