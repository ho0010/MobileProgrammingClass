package com.example.task2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.task2.model.DollPart
import com.example.task2.uicomponents.DollControls
import com.example.task2.uicomponents.DollImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = LocalConfiguration.current
            var selectedParts by rememberSaveable { mutableStateOf(setOf<DollPart>()) }

            val layoutModifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                Column(
                    modifier = layoutModifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DollImage(visibleParts = selectedParts, modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.height(16.dp))
                    DollControls(
                        selectedParts = selectedParts,
                        onCheckedChange = { part, isChecked ->
                            selectedParts =
                                if (isChecked) selectedParts + part else selectedParts - part
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DollImage(
                        visibleParts = selectedParts,
                        modifier = Modifier.weight(1f)
                    )
                    DollControls(
                        selectedParts = selectedParts,
                        onCheckedChange = { part, isChecked ->
                            selectedParts =
                                if (isChecked) selectedParts + part else selectedParts - part
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

        }
    }
}

// DollImage: 인형 부위 렌더링
// DollControls: 인형 부위 체크 컨트롤
// DollPart: 데이터 정의
