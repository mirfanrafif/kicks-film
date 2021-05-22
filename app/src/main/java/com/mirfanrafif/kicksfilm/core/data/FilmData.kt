package com.mirfanrafif.kicksfilm.core.data

import com.mirfanrafif.kicksfilm.core.domain.model.Movie


object FilmData {
    private val movies = arrayListOf(
        Movie(399566, "Godzilla vs. Kong", 2021,
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
        8.3, "Action, Science Fiction", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"),
    )

    fun getMovies(): List<Movie> = com.mirfanrafif.kicksfilm.core.data.FilmData.movies
}