package com.example.kotlin7.data.repository

import com.example.kotlin7.data.base.BaseRepository
import com.example.kotlin7.data.local.NoteDao
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import com.example.kotlin7.data.mappers.toNoteEntity
import com.example.kotlin7.data.mappers.toNote
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(toNoteEntity(note))
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(toNoteEntity(note))
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(toNoteEntity(note))
    }

    override fun getNote() = doRequest {
        noteDao.getNote().map { toNote(it) }
    }.flowOn(Dispatchers.IO)
}