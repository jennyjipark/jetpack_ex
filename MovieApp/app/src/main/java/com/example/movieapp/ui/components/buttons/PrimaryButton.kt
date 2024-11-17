package com.example.movieapp.ui.components.movie.buttons

import LeadingIconData
import Paddings
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

val LEADING_ICON_SIZE = 24.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    leadingIconData: LeadingIconData? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIconData?.let {
                Icon(
                    modifier = Modifier.size(LEADING_ICON_SIZE),
                    painter = painterResource(id = leadingIconData.iconDrawable),
                    contentDescription = leadingIconData.iconContentDescription?.let { desc -> stringResource(id = desc) }
                )
                Spacer(modifier = Modifier.width(Paddings.small))
            }
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
fun PrimaryButtonPreview() {
    MovieAppTheme {
        PrimaryButton(
            text = "SUBMIT"
        ) {

        }
    }

}