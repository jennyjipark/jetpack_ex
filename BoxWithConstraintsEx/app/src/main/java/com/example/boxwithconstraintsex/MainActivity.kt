package com.example.boxwithconstraintsex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boxwithconstraintsex.ui.theme.BoxWithConstraintsExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintsExTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    Column {
        Inner(modifier = Modifier
            .width(200.dp)
            .height(160.dp))
    }
}

@Composable
fun Inner(modifier: Modifier = Modifier) { // 기본값으로 Modifier를 전달하기 때문에 파라미터로 넣지 않아도 됨
    BoxWithConstraints(modifier) {
        if (maxHeight > 150.dp) {
            Text(
                text = "여기 꽤 길군요!",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text(text = "maxW: $maxWidth maxH: $maxHeight, minW: $minWidth, minH: $minHeight")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxWithConstraintsPreview() {
    BoxWithConstraintsExTheme {
        Outer()
    }
}