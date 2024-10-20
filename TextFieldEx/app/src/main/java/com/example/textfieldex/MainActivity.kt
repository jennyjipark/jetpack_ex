package com.example.textfieldex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfieldex.ui.theme.TextFieldExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldExTheme {
                TextFieldEx()
            }
        }
    }
}

@Composable
fun TextFieldEx() {

    var name by remember { mutableStateOf("Tom") }
    
    Column {
        // 1. TextField
//        TextField(
//            value = name,
//            // 텍스트 필드의 상태가 변할 떄의 값인 it가 name에 대입
//            // 텍스트 필드의 텍스트가 바뀔 때마다 계속 name에 대입되는 것
//            onValueChange = { name = it },
//            label = {
//                Text("이름")
//            }
//        )

        // 2. OutLinedTextField
        OutlinedTextField(
            value = name, onValueChange = { name = it }
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "Hello! $name")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFieldExTheme {
        TextFieldEx()
    }
}