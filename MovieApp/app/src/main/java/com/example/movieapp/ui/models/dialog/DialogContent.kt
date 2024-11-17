package com.example.movieapp.ui.models.dialog

import androidx.test.espresso.base.Default


sealed class DialogContent {
    data class Default(
        val dialogText: DialogText.Default
    ): DialogContent()

    data class Large(
        val dialogText: DialogText.Default
    ): DialogContent()

    data class Rating(
        val dialogText: DialogText.Rating
    ): DialogContent()

}
