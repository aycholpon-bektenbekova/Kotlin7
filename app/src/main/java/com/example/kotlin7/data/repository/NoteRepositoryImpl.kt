package com.example.kotlin7.data.repository

import com.example.kotlin7.data.local.NoteDao
import com.example.kotlin7.domain.model.Note
import com.example.kotlin7.domain.repository.NoteRepository
import com.example.kotlin7.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import com.example.kotlin7.data.mappers.toNoteEntity
import com.example.kotlin7.data.mappers.toNote
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository {

    override fun createNote(note: Note): Flow<Resource<Unit>> = flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.createNote(toNoteEntity(note))
            emit(Resource.Success(data))
        } catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage?: "error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.editNote(toNoteEntity(note))
            emit(Resource.Success(data))
        } catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage?: "error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.deleteNote(toNoteEntity(note))
            emit(Resource.Success(data))
        } catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage?: "error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getNote(): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.getNote().map { toNote(it) }
            emit(Resource.Success(data))
        } catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage?: "error"))
        }
    }.flowOn(Dispatchers.IO)
}