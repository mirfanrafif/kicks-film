package com.mirfanrafif.kicksfilm.utils

import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieItem
import com.mirfanrafif.kicksfilm.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntites(input: List<MovieItem>): List<MovieEntity> {
        return input.map { result ->
            val releaseDate = result.releaseDate.split("-").toTypedArray()
            MovieEntity(
                result.id,
                result.title,
                releaseDate[0].toInt(),
                result.overview,
                result.voteAverage,
                null,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2${result.backdropPath}")
        }
    }

    fun mapEntityToDomain(input: MovieEntity) : Movie = Movie(
        id = input.id,
        title = input.title,
        overview = input.overview,
        rating = input.rating,
        year = input.year,
        category = input.category,
        photo = input.photo,
        isFavorite = input.isFavorite
    )

    fun mapDomainToEntity(input: Movie): MovieEntity =
        MovieEntity(
            id = input.id,
            title = input.title,
            overview = input.overview,
            rating = input.rating,
            year = input.year,
            category = input.category,
            photo = input.photo,
            isFavorite = input.isFavorite
        )
}