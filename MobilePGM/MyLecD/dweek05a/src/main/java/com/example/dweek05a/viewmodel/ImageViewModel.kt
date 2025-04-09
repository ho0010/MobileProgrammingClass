package com.example.dweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dweek05a.model.ImageData
import com.example.dweek05a.model.ImageListFactory

class ImageViewModel : ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()
    val imageList: MutableList<ImageData>
        get() = _imageList
}

// viewModel 상속: 구성 변화(화면 전환)에도 데이터 유지
// 코드 구조:
// private val _imageList	외부에서 직접 수정하지 못하게 막음
// val imageList	외부에서 읽기만 가능하게 허용
// get() = _imageList	실질적으로 값을 넘겨주는 getter

//class ImageViewModel : ViewModel() {
//    private val _imageList = mutableStateListOf<ImageData>().apply {
//        addAll(ImageListFactory.makeImageList())
//    }
//
//    val imageList: MutableList<ImageData>
//        get() = _imageList
//}

