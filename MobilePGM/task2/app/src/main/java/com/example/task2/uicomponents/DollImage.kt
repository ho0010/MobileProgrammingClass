package com.example.task2.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.task2.R

@Composable
fun DollImage(selectedParts: Map<String, Boolean>) {
    Box(
        modifier = Modifier
            .size(240.dp)
            .border(1.dp, Color.Gray)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        // 실제 이미지 자리는 아래처럼 설정
        Image(
            painter = painterResource(id = R.drawable.placeholder), // 여기에 실제 인형 base 이미지
            contentDescription = "Doll Base"
        )

        // 각 파트별 이미지 레이어도 여기에 오버레이
        selectedParts.forEach { (part, isVisible) ->
            if (isVisible) {
                Text( // 실제론 Image(...)로 변경
                    text = part,
                    modifier = Modifier.offset(y = (10..100).random().dp),
                    color = Color.Black
                )
            }
        }
    }
}
