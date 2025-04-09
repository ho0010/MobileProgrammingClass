package com.example.dweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.dweek05a.model.ImageUri

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

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = img,
            contentDescription = "이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(
                    CircleShape
                )
        )
        button()
    }
}

//@Composable
//fun ImageWithButton(image: Int, modifier: Modifier = Modifier, button: @Composable () -> Unit) {
//    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//        AsyncImage(
//            model = image,
//            contentDescription = "이미지",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(200.dp)
//                .clip(
//                    CircleShape
//                )
//        )
//        button()
//    }
//}

//@Preview
//@Composable
//private fun ImageWithButtonPreview() {
//    var likes by remember { mutableIntStateOf(0) }
//    var dislikes by remember { mutableIntStateOf(0) }
//
//    ImageWithButton(image = R.drawable.img1) {
//        ButtonWithEmoji(likes, dislikes, { likes++ }, { dislikes++ })
//    }
//}