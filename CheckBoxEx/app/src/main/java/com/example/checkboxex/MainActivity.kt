package com.example.checkboxex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkboxex.ui.theme.CheckBoxExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxExTheme {
                CheckboxEx()
            }
        }
    }
}

@Composable
fun CheckboxEx() {
    Row(verticalAlignment = Alignment.CenterVertically) {

        // 스텝 1. 체크박스 만들기
//        Checkbox(checked = false, onCheckedChange = {} )

        // 스텝 2. onCheckedChange에서 boolean 값 변수를 바꾸고 checked에서 그 값을 반영 -> 잘 되지 않음
//        var checked = false // 단순 변수는 컴포즈의 상태변화에 영향을 주지 못함
//        Checkbox(
//            checked = false,
//            onCheckedChange = {
//                checked = !checked // 체크 시 checked 반전
//            }
//        )

        // 스텝 3. 단순 변수가 아닌 remember { mutableStateOf() } 사용으로 상태 변화 감지
        // - remember는 jetpack compose에서 상태를 기억하는 것
        // - 기억하는 이유는 compose가 언제든지 상태를 날려버릴 수 있기 때문
//        var checked = remember {
//            mutableStateOf(false)
//        }
//
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = {
//                checked.value = !checked.value // 체크 시 checked 반전
//            }
//        )
//
//        Text(text = "당신은 프로그래머 입니까?")

        // 스텝 4. delegated properties로 변경
        // - 위임된 속성
//        var checked by remember {
//            mutableStateOf(false)
//        }
//
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked // 체크 시 checked 반전
//            }
//        )
//
//        Text(text = "당신은 프로그래머 입니까?")

        // 스텝 5. 비구조화
        // destruction으로 상태를 받아서 사용
        // 순서대로 (getter, setter)
        var (getter, setter) = remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = getter, // 체크 상태
            onCheckedChange = {
                setter(!getter) // 체크 시 반전
            }
        )

        Text(
            text = "당신은 프로그래머 입니까?",
            modifier = Modifier.clickable {
                // 텍스트 클릭 시에도 체크박스 활성화
                setter(!getter)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxPreview() {
    CheckBoxExTheme {
        CheckboxEx()
    }
}