package com.example.columnexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.columnexample.ui.theme.ColumnExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnExampleTheme {
                ColumnExample()
            }
        }
    }
}

@Composable
fun ColumnExample() {
    Row {
        Column(
            // alignment - centerVertically, centerHorizontally
            // arrangement - center
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.size(100.dp),
        ) {
            Text(text = "첫 번쨰")
            Text(text = "두 번쨰")
            Text(text = "세 번쨰")
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.size(100.dp)
        ) {
            Text(
                text = "첫 번쨰",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = "두 번쨰")
            Text(
                text = "세 번쨰",
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnExamplePreview() {
    ColumnExampleTheme {
        ColumnExample()
    }
}