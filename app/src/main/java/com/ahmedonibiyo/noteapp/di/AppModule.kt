package com.ahmedonibiyo.noteapp.di

import androidx.room.Room
import com.ahmedonibiyo.noteapp.feature_note.data.data_source.NoteDatabase
import com.ahmedonibiyo.noteapp.feature_note.domain.repository.NoteRepositoryImpl
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.AddNote
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.DeleteNote
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.GetNotes
import com.ahmedonibiyo.noteapp.feature_note.domain.useCase.NoteUseCases
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
    singleOf(::NoteRepositoryImpl)
    single {
        NoteUseCases(
            getNotes = GetNotes(get()),
            deleteNote = DeleteNote(get()),
            addNote = AddNote(get())
        )
    }
}