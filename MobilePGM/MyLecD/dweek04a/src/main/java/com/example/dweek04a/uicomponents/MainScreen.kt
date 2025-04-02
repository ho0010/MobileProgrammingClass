package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoItemFactory
import com.example.dweek04a.model.TodoStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // 상태 선언, 초기 데이터도 넣음
    val todoList = remember {
        mutableStateListOf<Item>().apply {
            addAll(TodoItemFactory.makeTodoList())
        }
    }
    // 스위치 상태 선언
    var showOnlyPending by remember { mutableStateOf(false) }

    // showOnlyPending 값에 따라 리스트 필터링
    val filteredList = if (showOnlyPending) {
        todoList.filter { it.status == TodoStatus.PENDING }
    } else {
        todoList
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TodoListTitle()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "미완료 항목만 보기",
                modifier = Modifier
                    .padding(end = 8.dp)
            )
            Switch(
                checked = showOnlyPending,
                onCheckedChange = { showOnlyPending = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // onStatusChange로 체크박스 클릭시 상태 변경 로직구현
        // item의 인덱스를 찾고 copy로 복사본을 만들어서 status만 변경해서 리스트의 해당 인덱스에 할당
        TodoList(
            todoList = filteredList,
            onStatusChange = { item, checked ->
                val index = todoList.indexOf(item)
                if (index != -1) {
                    todoList[index] = item.copy(
                        status = if (checked) TodoStatus.COMPLETED else TodoStatus.PENDING
                    )
                }
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
    
}


// 첫번재 메인 화면 잘 조합해서 만들기
// 두번째  switch 컴포넌트 적용
// 가상기기 만들어서 운영 34로 => mainActivity에서 호출하면 됨
// 보고서에는 화면만 코드는 깃헙에 올려서 첨부