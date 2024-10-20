package com.example.slotapiex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import com.example.slotapiex.ui.theme.SlotAPIExTheme
import java.sql.RowId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotAPIExTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlotAPIex()
                }
            }
        }
    }
}

// 스텝 1. Row를 Composable 함수로 분리
//@Composable
//fun CheckboxWithText(checked: MutableState<Boolean>, text: String) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        Text(
//            text = "$text",
//            modifier = Modifier.clickable { checked.value = checked.value }
//        )
//    }
//}

// 스텝 2. Composable 함수에서 @Composable () -> Unit 타입으로 content를 받아옵시다. Row의 Text를 빼고 content()를 넣읍시다.
// Row에 Modifier.clickable을 넣어 전체를 클릭가능하게 합시다.

//@Composable
//fun CheckboxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable () -> Unit // 슬롯api
//    // RowScope를 하는 이유
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}

// 스텝 3. RowScope.() -> Unit
//@Composable
//fun CheckboxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable RowScope.() -> Unit // 슬롯api
//    // RowScope를 하는 이유
//
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content() // content: @Composable RowScope.() -> Unit
//    }
//}


// 스텝 4. 상태를 바꾸는 람다를 @Composable 함수의 인자로 뺸다.
// 인자에서 MutableState 대신 Boolean 값으로 변경한다.
@Composable
fun CheckboxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit // 슬롯api

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content() // content: @Composable RowScope.() -> Unit
    }
}

@Composable
fun SlotAPIex() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    // 스텝 1 방법
//    Column {
//        CheckboxWithText(checked1, "텍스트1")
//        CheckboxWithText(checked2, "텍스트2")
//    }
//    CheckboxWithSlot(checked1, {Text("텍스트 1")})

    // Lambda argument should be moved out of parentheses
//    CheckboxWithSlot(checked1) {
//        Text("텍스트 2")
//    }

    Column {
        CheckboxWithSlot(
            checked = checked1,
            onCheckedChanged = {checked1 = !checked1}
        ) {
            Text("텍스트 1")
        }

        CheckboxWithSlot(
            checked = checked2,
            onCheckedChanged = {checked2 = !checked2}
        ) {
            Text("텍스트 2")
        }
    }
    

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlotAPIExTheme {
        SlotAPIex()
    }
}