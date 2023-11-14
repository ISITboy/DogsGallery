package com.example.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.ConstantsDatabase.TABLE_NOTE
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = TABLE_NOTE)
data class Photo(
    @PrimaryKey val urlToImage: String
):Parcelable
