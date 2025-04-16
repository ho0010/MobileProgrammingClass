package com.example.dweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.dweek05a.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.BADGE,
            likes = 50,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.ICON,
            likes = 100,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.BADGE,
            likes = 100,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 15,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 15,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 15,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 15,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 15,
        ), ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 100,
            dislikes = 15,
        )

    )
}