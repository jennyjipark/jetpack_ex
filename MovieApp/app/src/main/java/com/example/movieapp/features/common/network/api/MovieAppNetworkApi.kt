package com.example.movieapp.features.common.network.api

import com.example.movieapp.features.common.network.model.MovieResponse
import com.example.movieapp.libraries.network.model.ApiResult
import com.example.movieapp.libraries.network.retrofit.NetworkRequestFactory
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MovieAppNetworkApi @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
): IMovieAppNetworkApi {
    override suspend fun getMovies(): ApiResult<List<MovieResponse>> {
        return networkRequestFactory.create(
            url = "top250.json",
            type = object: TypeToken<List<MovieResponse>>(){}.type
        )
    }

}