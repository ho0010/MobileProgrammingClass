package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.task2.uicomponents.DollImage
import com.example.task2.uicomponents.PartCheckbox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DollApp();
        }
    }
}

@Composable
fun DollApp() {
    val parts = remember {
        mutableStateMapOf(
            "arms" to true,
            "eyebrows" to true,
            "ears" to false,
            "eyes" to true,
            "glasses" to true,
            "hat" to true,
            "mouth" to false,
            "mustache" to false,
            "nose" to true,
            "shoes" to true
        )
    }

    Row(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        // 왼쪽: 이미지
        DollImage(selectedParts = parts)

        Spacer(modifier = Modifier.width(24.dp))

        // 오른쪽: 체크박스 리스트
        LazyColumn {
            items(parts.keys.toList()) { key ->
                PartCheckbox(
                    label = key,
                    checked = parts[key] ?: false,
                    onCheckedChange = { parts[key] = it }
                )
            }
        }
    }
}
