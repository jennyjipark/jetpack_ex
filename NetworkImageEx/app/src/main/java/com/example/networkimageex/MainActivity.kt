package com.example.networkimageex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.networkimageex.ui.theme.NetworkImageExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImageExTheme {
                CoilEx()
            }
        }
    }
}

@Composable
fun CoilEx() {

    // 1. rememberImagePainter
    // - coil 라이브러리 함수
    // - 이미지 비동기 로드
    // - 컴포즈 재렌더링 할 때 이미지가 유지되어 재로드되지 않고 기존의 이미지가 표시

    // 2. AsyncImage

    // rememberImagePainter 사용해서 Image의 painter를 설정
    // rememberImagePainter의 용도
    val painter = rememberImagePainter(data = "https://images.mypetlife.co.kr/content/uploads/2023/07/12164504/AdobeStock_600875580-1024x683.jpeg")

    Image(
        painter = painter,
        contentDescription = "고양이" // 접근성을 위해 작성 권장
    )

    // AsyncImage 사용
    Column {
        AsyncImage(
            model = "https://images.mypetlife.co.kr/content/uploads/2023/07/12164504/AdobeStock_600875580-1024x683.jpeg",
            contentDescription = "고양이"
        )

        AsyncImage(
            model = "https://images.mypetlife.co.kr/content/uploads/2023/07/12164504/AdobeStock_600875580-1024x683.jpeg",
            contentDescription = "고양이"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkImageExTheme {
        CoilEx()
    }
}