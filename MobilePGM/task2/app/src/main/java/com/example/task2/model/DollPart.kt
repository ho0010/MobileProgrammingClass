package com.example.task2.model

import androidx.annotation.DrawableRes
import com.example.task2.R

enum class DollPart(val label: String, @DrawableRes val resId: Int) {
    ARMS("arms", R.drawable.arms),
    EARS("ears", R.drawable.ears),
    EYEBROWS("eyebrows", R.drawable.eyebrows),
    EYES("eyes", R.drawable.eyes),
    GLASSES("glasses", R.drawable.glasses),
    HAT("hat", R.drawable.hat),
    MOUTH("mouth", R.drawable.mouth),
    MUSTACHE("mustache", R.drawable.mustache),
    NOSE("nose", R.drawable.nose),
    SHOES("shoes", R.drawable.shoes),
    BODY("body", R.drawable.body),
    TEXT("202312379-지호준", R.drawable.body)
}
