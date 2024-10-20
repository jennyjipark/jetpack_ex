package com.example.slopapiex_prac1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.slopapiex_prac1.ui.theme.SlopAPIEx_prac1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlopAPIEx_prac1Theme {
                SlotAPIEx()
            }
        }
    }
}

@Composable
fun SlotAPIRow(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    txt: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() }
        )
        Text(
            text = txt,
            Modifier.clickable { // 텍스트 눌러도 클릭 가능
                onCheckedChange()
            }
        )
    }
}

@Composable
fun SlotAPIEx(
) {
    var checked1 by remember {
        mutableStateOf(false)
    }

    var checked2 by remember {
        mutableStateOf(false)
    }

    Column {
        SlotAPIRow(
            checked = checked1,
            onCheckedChange = { checked1 = !checked1 },
            "체크박스1"
        )

        SlotAPIRow(
            checked = checked2,
            onCheckedChange = { checked2 = !checked2 },
            "체크박스2"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlopAPIEx_prac1Theme {
        SlotAPIEx()
    }
}