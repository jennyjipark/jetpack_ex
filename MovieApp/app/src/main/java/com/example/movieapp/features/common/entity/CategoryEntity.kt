package com.example.movieapp.features.common.entity

data class CategoryEntity(
    val id: Int,
    val genre: String,
    val movieDetailEntities: List<MovieFeedItemEntity>
)
