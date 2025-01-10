package com.ahmedonibiyo.noteapp.feature_note.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen : Screen("notes_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")
    object SignInScreen : Screen("sign_in_screen")
    object ProfileScreen : Screen("profile_screen")
}
