package com.example.surfaceexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surfaceexample.ui.theme.SurfaceExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceExampleTheme {
                    Greeting("Android")
                }
            }
        }
    }

@Composable
fun Greeting(name: String) {
    Surface(
        border = BorderStroke(2.dp, Color.Magenta),
        modifier = Modifier.padding(30.dp),
        shadowElevation = 10.dp, // 그림자 효과
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp),
            color = Color.White

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SurfaceExampleTheme {
        Greeting("Android")
    }
}