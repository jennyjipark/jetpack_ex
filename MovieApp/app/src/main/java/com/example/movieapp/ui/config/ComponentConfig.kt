package com.example.movieapp.ui.config

import ColorSet
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography

data class ComponentConfig(
    val colors: ColorSet,
    val typography: Typography,
    val shapes: Shapes,
    val isDarkTheme: Boolean
)