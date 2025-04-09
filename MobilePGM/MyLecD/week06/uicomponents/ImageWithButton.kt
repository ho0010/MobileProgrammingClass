package com.example.week06.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.week06.model.ImageUri

@Composable
fun ImageWithButton(
    image: ImageUri,
    modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    val img = when (image) {
        is ImageUri.ResImage -> image.resID
        is ImageUri.WebImage -> image.webUrl
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = img,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        button()
    }
}
