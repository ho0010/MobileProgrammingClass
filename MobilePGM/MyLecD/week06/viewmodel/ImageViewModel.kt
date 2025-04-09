package com.example.week06.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week06.model.ImageData
import com.example.week06.model.ImageListFactory

class ImageViewModel: ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()
    val imageList:MutableList<ImageData>
        get() = _imageList
}