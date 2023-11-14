package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.manger.PhotosDogDao
import com.example.domain.model.Photo

@Database(entities = [Photo::class],version = 1,)
abstract class Database :RoomDatabase(){
    abstract val photosDogDao: PhotosDogDao
}