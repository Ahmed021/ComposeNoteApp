package com.ahmedonibiyo.noteapp.feature_note.domain.useCase

import com.ahmedonibiyo.noteapp.feature_note.domain.model.InvalidNoteException
import com.ahmedonibiyo.noteapp.feature_note.domain.model.Note
import com.ahmedonibiyo.noteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()){
            throw InvalidNoteException("The title of the note can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}