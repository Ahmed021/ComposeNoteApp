package com.ahmedonibiyo.noteapp.di

import androidx.room.Room
import com.ahmedonibiyo.noteapp.feature_note.data.data_source.NoteDatabase
import com.ahmedonibiyo.noteapp.feature_note.domain.repository.NoteRepository
import com.ahmedonibiyo.noteapp.feature_note.domain.repository.NoteRepositoryImpl
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.AddNote
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.DeleteNote
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.GetNote
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.GetNotes
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.NoteUseCases
import com.ahmedonibiyo.noteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.ahmedonibiyo.noteapp.feature_note.presentation.notes.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
    single { get<NoteDatabase>().noteDao() }
    single<NoteRepository> { NoteRepositoryImpl(get()) }
    single { GetNote(get()) }
    single { DeleteNote(get()) }
    single { AddNote(get()) }
    single { GetNote(get()) }
    single {
        NoteUseCases(
            getNotes = GetNotes(get()),
            deleteNote = DeleteNote(get()),
            addNote = AddNote(get()),
            getNote = GetNote(get())
        )
    }

    viewModel { NotesViewModel(get()) }
    viewModel { AddEditNoteViewModel(get(), get()) }
}
