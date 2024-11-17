package com.example.movieapp.ui.components.movie.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.MovieAppTheme

@Composable
fun SecondaryBorderlessButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                // id가 null이 아니면 id를 text로 사용하고,
                // null이면 기존 text값을 그대로 사용
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(Paddings.small)
            )
        }
    }
}

@Preview
@Composable
fun SecondaryBorderlessButtonPreview() {
    MovieAppTheme {
        PrimaryButton(
            text = "CANCEL"
        ) {

        }
    }
}