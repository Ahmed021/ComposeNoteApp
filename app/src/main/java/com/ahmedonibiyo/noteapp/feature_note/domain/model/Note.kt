package com.ahmedonibiyo.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.compose.BabyBlue
import com.example.compose.LightGreen
import com.example.compose.RedOrange
import com.example.compose.RedPink
import com.example.compose.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null, 
    val imageData: ByteArray? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (title != other.title) return false
        if (content != other.content) return false
        if (timestamp != other.timestamp) return false
        if (color != other.color) return false
        if (id != other.id) return false
        if (imageData != null) {
            if (other.imageData == null) return false
            if (!imageData.contentEquals(other.imageData)) return false
        } else if (other.imageData != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + timestamp.hashCode()
        result = 31 * result + color
        result = 31 * result + (id ?: 0)
        result = 31 * result + (imageData?.contentHashCode() ?: 0)
        return result
    }
}

class InvalidNoteException(message: String): Exception(message)
