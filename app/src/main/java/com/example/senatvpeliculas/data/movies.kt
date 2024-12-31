package com.example.senatvpeliculas.data

import com.example.senatvpeliculas.model.Movie

object MovieData {
    val genders = mapOf(
        "1" to "Acción",
        "2" to "Comedia",
        "3" to "Drama",
        "4" to "Terror",
        "5" to "Romance",
        "6" to "Ciencia Ficción",
        "7" to "Musical"
    )
    val movies = listOf(
        Movie(
            titulo = "Inception",
            anioLanzamiento = "2014",
            generoContenidoCodigo = "6",
            imagenUrl = "https://example.com/inception.jpg",
            sinopsis = "A thief who steals corporate secrets through dream-sharing technology.",
            director = "Director 1",
            usuarioCreacion = "1",
            tipoContenidoCodigo = "1"
        ),
        Movie(
            titulo = "The Dark Knight",
            anioLanzamiento = "2014",
            generoContenidoCodigo = "6",
            imagenUrl = "https://example.com/dark_knight.jpg",
            sinopsis = "Batman raises the stakes in his war on crime.",
            director = "Director 2",
            usuarioCreacion = "1",
            tipoContenidoCodigo = "1"
        ),
        Movie(
            titulo = "Interstellar",
            anioLanzamiento = "2014",
            generoContenidoCodigo = "6",
            imagenUrl = "https://example.com/interstellar.jpg",
            sinopsis = "A team of explorers travel through a wormhole in space.",
            director = "Director 3",
            usuarioCreacion = "1",
            tipoContenidoCodigo = "1"
        )
    )
}