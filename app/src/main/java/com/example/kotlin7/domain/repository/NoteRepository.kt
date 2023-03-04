package com.example.kotlin7.domain.repository

import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note):Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

    fun getNote(): Flow<Resource<List<Note>>>
}