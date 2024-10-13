package com.example.boxexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boxexample.ui.theme.BoxExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxExampleTheme {
                    BoxExample()
                }
            }
        }
    }

@Composable
fun BoxExample() {
//    Box(
//        modifier = Modifier.size(100.dp)
//    ) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
//        Text(text = "Jetpack", modifier = Modifier.align(Alignment.TopStart))
//        Text(text = "Compose", modifier = Modifier.align(Alignment.CenterStart))
//    }

//    Box(Modifier.size(100.dp)) {
//        Box(
//            modifier = Modifier.size(70.dp)
//                .background(Color.Cyan)
//                .align(Alignment.TopStart)
//        )
//        Box(
//            modifier = Modifier.size(70.dp)
//                .background(Color.Magenta)
//                .align(Alignment.BottomEnd)
//        )
//    }

    // 자식 박스 사이즈를
    // fillMaxSize(), matchParentSize()로 설정
    Box {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Cyan)
                .align(Alignment.TopStart)
        )
        Box(
            modifier = Modifier.size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.Center)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxExampleTheme {
        BoxExample()
    }
}