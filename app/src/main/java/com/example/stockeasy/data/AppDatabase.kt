package com.example.stockeasy.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ListaEntity::class, ProductoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listaDao(): ListaDao
    abstract fun productoDao(): ProductoDao
}