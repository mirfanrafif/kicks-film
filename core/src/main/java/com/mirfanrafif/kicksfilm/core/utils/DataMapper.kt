package com.mirfanrafif.kicksfilm.core.utils

import com.mirfanrafif.kicksfilm.core.data.source.local.entities.MovieEntity
import com.mirfanrafif.kicksfilm.core.data.source.remote.responses.MovieItem
import com.mirfanrafif.kicksfilm.core.domain.model.Movie

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

    fun mapEntityToDomain(input: List<MovieEntity>) : List<Movie> = input.map {
        Movie(
            id = it.id,
            title = it.title,
            overview = it.overview,
            rating = it.rating,
            year = it.year,
            category = it.category,
            photo = it.photo,
            isFavorite = it.isFavorite
        )
    }

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