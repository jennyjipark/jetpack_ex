package com.example.buttonexample

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttonexample.ui.theme.ButtonExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonExampleTheme {
                ButtonExample(onButtonClicked = {
                    Toast.makeText(
                        this,
                        "Send Clicked",
                        Toast.LENGTH_SHORT).show()
                }) // 버튼 클릭시 {}가 수행
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    // 스텝 1: 버튼 클릭했을 때 Toast 출력
//    Button(onClick = onButtonClicked) { // 클릭 이벤트
//        Text(text = "Send")
//    }

    // 스텝 2: 아이콘을 텍스트 앞에 추가
    // - imageVector에는 Icons.Filled.Send를 넣고
    // - contentDescription에는 null 넣기
    // - 아이콘과 텍스트 사이에 Spacer 넣기

//    Button(
//        onClick = onButtonClicked,
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        // 여백
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 스텝 3: enabled를 false로 설정
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        // 여백
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 스텝 4: shape을 CircleShape으로 지정
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta),
//        shape = CircleShape
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        // 여백
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 스텝 5: contentPadding에 PaddingValues 설정
    Button(
        onClick = onButtonClicked,
        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta),
        shape = RectangleShape,
        contentPadding = PaddingValues(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        // 여백
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ButtonExampleTheme {
        ButtonExample(onButtonClicked = {})
    }
}