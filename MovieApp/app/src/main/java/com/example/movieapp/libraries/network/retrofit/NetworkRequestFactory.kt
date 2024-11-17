package com.example.movieapp.libraries.network.retrofit

import com.example.movieapp.libraries.network.model.ApiResult
import com.example.movieapp.libraries.network.model.NetworkRequestInfo
import java.lang.reflect.Type

interface NetworkRequestFactory {

    suspend fun <T> create(
        url: String,
        requestInfo: NetworkRequestInfo = NetworkRequestInfo.Builder().build(),
        type: Type
    ): ApiResult<T>
}