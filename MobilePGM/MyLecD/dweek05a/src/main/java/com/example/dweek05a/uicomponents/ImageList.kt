package com.example.dweek05a.uicomponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dweek05a.model.ButtonType
import com.example.dweek05a.model.ImageData
import com.example.dweek05a.uiexamples.ScrollToTopButton
import kotlinx.coroutines.launch

@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageList: MutableList<ImageData>,
    isPortrait: Boolean
) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (isPortrait) {
            LazyColumn(
                modifier = modifier.fillMaxWidth(),
                state = state,
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(imageList) { index, imageData ->
                    ImageListItem(index, imageData, imageList)
                }
            }

            AnimatedVisibility(visible = showButton) {
                ScrollToTopButton {
                    scope.launch {
                        state.scrollToItem(0)
                    }
                }
            }
        } else {
            LazyRow(
                modifier = modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                itemsIndexed(imageList) { index, imageData ->
                    ImageListItem(index, imageData, imageList)
                }
            }
        }
    }
}


// 버튼 타입에 따른 렌더링
@Composable
fun ImageListItem(
    index: Int, imageData: ImageData, imageList: MutableList<ImageData>
) {
    when (imageData.buttonType) {
        ButtonType.ICON -> {
            ImageWithButton(image = imageData.imageUri) {
                ButtonWithIcon(likes = imageData.likes) {
                    imageList[index] = imageData.copy(likes = imageData.likes + 1)
                }
            }
        }

        ButtonType.BADGE -> {
            ImageWithButton(image = imageData.imageUri) {
                ButtonWithBadge(likes = imageData.likes) {
                    imageList[index] = imageData.copy(likes = imageData.likes + 1)
                }
            }
        }

        ButtonType.EMOJI -> {
            ImageWithButton(image = imageData.imageUri) {
                ButtonWithEmoji(likes = imageData.likes,
                    dislikes = imageData.dislikes,
                    onClickLikes = {
                        imageList[index] = imageData.copy(likes = imageData.likes + 1)
                    },
                    onClickDisLikes = {
                        imageList[index] = imageData.copy(dislikes = imageData.dislikes + 1)
                    })
            }
        }

    }
}
