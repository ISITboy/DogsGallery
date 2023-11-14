package com.example.domain.manger

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.ConstantsDatabase.TABLE_NOTE
import com.example.domain.model.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotosDogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo)

    @Delete
    suspend fun delete(photo: Photo)

    @Query("SELECT * FROM $TABLE_NOTE")
    fun getPhotos(): Flow<List<Photo>>

    @Query("SELECT * FROM $TABLE_NOTE WHERE urlToImage=:url")
    suspend fun getPhoto(url: String): Photo?
}