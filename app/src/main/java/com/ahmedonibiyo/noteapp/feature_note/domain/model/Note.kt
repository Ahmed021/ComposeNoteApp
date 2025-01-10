package com.ahmedonibiyo.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahmedonibiyo.noteapp.ui.theme.BabyBlue
import com.ahmedonibiyo.noteapp.ui.theme.LightGreen
import com.ahmedonibiyo.noteapp.ui.theme.RedOrange
import com.ahmedonibiyo.noteapp.ui.theme.RedPink
import com.ahmedonibiyo.noteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null,
    val mediaFile: String? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }

}

class InvalidNoteException(message: String): Exception(message)
