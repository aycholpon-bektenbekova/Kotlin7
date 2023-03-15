package com.example.kotlin7.data.mappers

import com.example.kotlin7.data.model.NoteEntity
import com.example.kotlin7.domain.model.Note

fun toNote(noteEntity: NoteEntity):Note{
    return Note(
        noteEntity.id,
        noteEntity.title,
        noteEntity.description,
        )
}

fun toNoteEntity(note: Note): NoteEntity {
    return NoteEntity(
        note.id,
        note.title,
        note.description,
    )
}