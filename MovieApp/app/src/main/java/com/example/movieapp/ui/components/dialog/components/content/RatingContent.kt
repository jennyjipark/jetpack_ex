package com.example.movieapp.ui.components.dialog.components.content

import Paddings
import android.content.res.ColorStateList
import android.widget.RatingBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import com.example.movieapp.ui.models.dialog.DialogText
import kr.co.fastcampus.part4plus.movieapp.ui.util.getAnnotatedText

@Composable
fun RatingContent(content: DialogText.Rating) {
    Column(
        modifier = Modifier.padding(
            top = Paddings.large,
            bottom =Paddings.xlarge
        )
    ) {
        RatingTable(
            rating = content.rating,
            movieTitle = content.text ?: ""
        )
    }
}

@Composable
fun ColumnScope.RatingTable(
    rating: Float,
    movieTitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
    ) {
        Text(
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            ),
            text = getAnnotatedText(text = movieTitle),
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.secondary
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Paddings.large))
        StarRatingBar(
            score = rating
        )
    }
}

@Composable
fun ColumnScope.StarRatingBar(score: Float) {
    Card(
        modifier = Modifier
            .padding(
                Paddings.medium
            )
            .wrapContentSize()
            .align(Alignment.CenterHorizontally),
//        elevation =
    ) {
        val foregroundColor = MaterialTheme.colorScheme.primary.toArgb()
        val starBackgroundColor = MaterialTheme.colorScheme.primaryContainer.copy(
            alpha = 0.2f
        ).toArgb()
        val ratingBackgroundColor = MaterialTheme.colorScheme.primaryContainer.copy(
            alpha = 0.05f
        ).toArgb()

        // 별점 클릭했을 때 레이아웃 변경
        AndroidView( // 마치 addView를 사용
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            factory = {
                RatingBar(
                    it
                ).apply {
                    max = 10
                    stepSize = 25f
                    rating = score
                    numStars = 5
                    progressTintList = ColorStateList.valueOf(starBackgroundColor)
                    setBackgroundColor(ratingBackgroundColor)
                }
            }
        )
    }
}


