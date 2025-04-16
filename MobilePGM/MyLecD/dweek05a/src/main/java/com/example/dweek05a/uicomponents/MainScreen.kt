package com.example.dweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation

    val isPortrait = orientation == Configuration.ORIENTATION_PORTRAIT

    ImageList(
        modifier = modifier,
        imageList = imageList,
        isPortrait = isPortrait
    )
}

// mainScreen에서는 데이터와 방향만 전달, 화면 렌더링은 ImageList에서

// MVVM
// ImageData: 데이터 형식 정의, ImageListFactory: 만들어놓은 ImageData 형식 이용해서 상태 데이터 생성, ImageViewModel: 데이터 생성 및 관리
// MainScreen: 화면 방향에 따른  수직, 수평 레이아웃 설정, ImageList: 각 ImageData의 buttonType에 따라 적절한 버튼 UI 생성
// copy()를 통해 새로운 ImageData 객체를 생성해서 리스트 요소 교체 , 리스트가 mutableStateListOf이므로 Compose가 이 변화를 감지하고 해당 UI만 리컴포지션

//    var img1State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//    var img2State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 100,
//                dislikes = 10
//            )
//        )
//    }
//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                img1State = img1State.copy(likes = img1State.likes + 1)
//            }
//        }
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(likes = img2State.likes + 1)
//                },
//                onClickDisLikes = {
//                    img2State = img2State.copy(dislikes = img2State.dislikes + 1)
//                })
//
//        }
//
//    }