package com.ahmedonibiyo.noteapp.feature_note.domain.useCase

import com.ahmedonibiyo.noteapp.feature_note.domain.model.Note
import com.ahmedonibiyo.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}