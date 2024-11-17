package com.example.movieapp.ui.components.dialog

import LeadingIconData
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.ui.models.dialog.DialogButton
import com.example.movieapp.ui.theme.MovieAppTheme

@Preview
@Composable
fun AlertPreview() {
    MovieAppTheme {
        DialogPopup.Alert(
            title = "Title",
            bodyText = "블라 블라 블라",
             buttons = listOf(
                DialogButton.UnderlinedText("Okay") {}
            )
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        DialogPopup.Alert(
            title = "Title",
            bodyText = "블라 블라 블라",
            buttons = listOf(
                DialogButton.Primary("Okay"),
                DialogButton.SecondaryBorderless("Okay")
            )
        )
    }
}

@Preview
@Composable
fun RatingPreview() {
    MovieAppTheme {
        DialogPopup.Rating(
            movieName = "The Lord of The Rings",
            rating = 7.2f,
            buttons = listOf(
                DialogButton.Primary(
                    title = "OPEN",
                    leadingIconData = LeadingIconData(
                        iconDrawable = R.drawable.ic_send,
                        iconContentDescription = null
                    )
                ){},
                DialogButton.SecondaryBorderless("Okay")
            )
        )
    }
}