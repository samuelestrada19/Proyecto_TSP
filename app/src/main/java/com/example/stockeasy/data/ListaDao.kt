package com.example.stockeasy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ListaDao {
    @Insert
    fun insertar(lista: ListaEntity): Long

    @Delete
    fun eliminar(lista: ListaEntity)

    @Query("SELECT * FROM listas")
    fun obtenerListas(): List<ListaEntity>
}