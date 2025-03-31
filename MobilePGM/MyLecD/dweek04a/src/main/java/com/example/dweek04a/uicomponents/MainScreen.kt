package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.dweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        // mutableStateListOf<Item>() 빈 리스트
        TodoItemFactory.makeTodoList()
    }
    Column {
        TodoListTitle()


    }
}

// 첫번재 메인 화면 잘 조합해서 만들기
// 두번째  switch 컴포넌트 적용
// 가상기기 만들어서 운영 34로 => mainActivity에서 호출하면 됨
// 보고서에는 화면만 코드는 깃헙에 올려서 첨부