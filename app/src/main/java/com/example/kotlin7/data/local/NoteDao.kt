package com.example.kotlin7.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlin7.data.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getNote(): List<NoteEntity>
}