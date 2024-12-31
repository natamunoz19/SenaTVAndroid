package com.example.senatvpeliculas.model

data class Movie(
    val titulo: String,
    val sinopsis: String,
    val anioLanzamiento: String,
    val imagenUrl: String,
    val director: String,
    val usuarioCreacion: String,
    val tipoContenidoCodigo: String,
    val generoContenidoCodigo: String,
)
