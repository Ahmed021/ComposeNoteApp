package com.ahmedonibiyo.noteapp.feature_note.presentation.sign_in

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
