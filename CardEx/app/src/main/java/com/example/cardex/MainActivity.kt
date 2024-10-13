package com.example.cardex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cardex.ui.theme.CardExTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardExTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column {
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }

    // CardData
    companion object {
        val cardData = CardData(
            imageUri = "https://www.fitpetmall.com/wp-content/uploads/2023/09/shutterstock_2205178589-1-1.png",
            imageDescription = "고양이",
            author = "google",
            description = "고양이는 너무 사랑스러운 동물이야"
        )
    }
}

@Composable
fun CardEx(cardData: CardData) { // CardData 객체를 넘겨줌
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation( // 떠있는 효과
            defaultElevation = 8.dp
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUri,
                contentScale = ContentScale.Crop, // 영역에 맞게 자르기
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier.size(32.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(
                    text = cardData.author
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = cardData.description
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardExTheme {
        Row {
            CardEx(MainActivity.cardData)
        }
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)