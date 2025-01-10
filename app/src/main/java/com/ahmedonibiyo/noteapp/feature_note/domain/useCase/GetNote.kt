package com.ahmedonibiyo.noteapp.feature_note.domain.useCase

import com.ahmedonibiyo.noteapp.feature_note.domain.model.Note
import com.ahmedonibiyo.noteapp.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}