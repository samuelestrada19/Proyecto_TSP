package com.example.stockeasy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface ProductoDao {
    @Insert
    fun insertar(producto: ProductoEntity): Long

    @Delete
    fun eliminar(producto: ProductoEntity)

    @Query("SELECT * FROM productos WHERE listaId = :listaId")
    fun obtenerProductosDeLista(listaId: Int): List<ProductoEntity>
}
