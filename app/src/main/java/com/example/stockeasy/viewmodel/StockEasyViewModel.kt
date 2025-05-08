package com.example.stockeasy.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.stockeasy.data.AppDatabase
import com.example.stockeasy.data.ListaEntity
import com.example.stockeasy.data.ProductoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StockEasyViewModel(application: Application) : AndroidViewModel(application) {

    // Crear base de datos de forma segura y perezosa
    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            getApplication(),
            AppDatabase::class.java,
            "stockeasy-db"
        )
            .fallbackToDestructiveMigration() // ✔️ Borra la BD si el esquema cambia (solo para desarrollo)
            .build()
    }

    val listas = mutableStateListOf<ListaEntity>()
    val productos = mutableStateListOf<ProductoEntity>()

    fun cargarListas() {
        viewModelScope.launch {
            val datos = withContext(Dispatchers.IO) {
                db.listaDao().obtenerListas()
            }
            listas.clear()
            listas.addAll(datos)
        }
    }

    fun agregarLista(nombre: String, descripcion: String) {
        viewModelScope.launch {
            val nuevaLista = ListaEntity(nombre = nombre, descripcion = descripcion)
            withContext(Dispatchers.IO) {
                db.listaDao().insertar(nuevaLista)
            }
            cargarListas()
        }
    }

    fun eliminarLista(lista: ListaEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.listaDao().eliminar(lista)
            }
            cargarListas()
        }
    }

    fun agregarProducto(
        nombre: String,
        descripcion: String,
        codigo: String,
        existencias: Int,
        listaId: Int
    ) {
        viewModelScope.launch {
            val nuevoProducto = ProductoEntity(
                nombre = nombre,
                descripcion = descripcion,
                codigo = codigo,
                existencias = existencias,
                listaId = listaId
            )
            withContext(Dispatchers.IO) {
                db.productoDao().insertar(nuevoProducto)
            }
            cargarProductosDeLista(listaId)
        }
    }

    fun eliminarProducto(producto: ProductoEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.productoDao().eliminar(producto)
            }
            cargarProductosDeLista(producto.listaId)
        }
    }

    fun cargarProductosDeLista(listaId: Int) {
        viewModelScope.launch {
            val datos = withContext(Dispatchers.IO) {
                db.productoDao().obtenerProductosDeLista(listaId)
            }
            productos.clear()
            productos.addAll(datos)
        }
    }
}