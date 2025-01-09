package com.ahmedonibiyo.noteapp.feature_note.domain.useCase

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote
)
