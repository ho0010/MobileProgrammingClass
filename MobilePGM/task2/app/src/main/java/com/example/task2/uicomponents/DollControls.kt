package com.example.task2.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.task2.model.DollPart

@Composable
fun DollControls(
    selectedParts: Set<DollPart>,
    onCheckedChange: (DollPart, Boolean) -> Unit, modifier: Modifier = Modifier
) {
    val partsToShow = DollPart.values().filter { it != DollPart.BODY }

    Column(
        modifier = modifier
            .padding(4.dp)
    ) {
        partsToShow.chunked(2).forEach { row ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { part ->
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = selectedParts.contains(part),
                            onCheckedChange = { onCheckedChange(part, it) }
                        )
                        Text(
                            part.label, modifier = Modifier.padding(start = 4.dp)
                        )

                    }
                }
            }
        }
    }
}
