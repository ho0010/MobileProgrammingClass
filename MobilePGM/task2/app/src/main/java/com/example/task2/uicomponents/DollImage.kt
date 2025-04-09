package com.example.task2.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.task2.model.DollPart

@Composable
fun DollImage(
    visibleParts: Set<DollPart>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(DollPart.BODY.resId), contentDescription = "body")

        visibleParts.forEach { part ->
            if (part != DollPart.BODY) {
                Image(painter = painterResource(part.resId), contentDescription = part.label)
            }
        }
    }
}
