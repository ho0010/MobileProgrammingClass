package com.example.week06.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.week04.uicomponents.ButtonWithEmoji
import com.example.week04.uicomponents.ButtonWithIcon
import com.example.week06.model.ButtonType
import com.example.week06.model.ImageData

@Composable
fun ImageList(modifier: Modifier = Modifier, imageList: MutableList<ImageData>) {
    imageList.forEachIndexed { index, imageData ->
        when(imageData.buttonType){
            ButtonType.ICON -> {
                ImageWithButton(image = imageData.imageUri) {
                    ButtonWithIcon(likes = imageData.likes) {
                        imageList[index] = imageData.copy(likes = imageData.likes+1)
                    }
                }
            }
            ButtonType.BADGE -> {
                ImageWithButton(image = imageData.imageUri) {
                    ButtonWithBadge(likes = imageData.likes) {
                        imageList[index] = imageData.copy(likes = imageData.likes+1)
                    }
                }
            }
            ButtonType.EMOJI -> {
                ImageWithButton(image = imageData.imageUri) {
                    ButtonWithEmoji(
                        likes = imageData.likes,
                        dislikes = imageData.dislikes,
                        onClickLikes = {imageList[index] = imageData.copy(likes = imageData.likes+1)},
                        onClickDisLikes = {imageList[index] = imageData.copy(dislikes = imageData.dislikes+1)}
                    )
                }
            }
        }
    }
}