package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoItemFactory
import com.example.dweek04a.model.TodoStatus

@Composable
fun TodoList(
    todoList: List<Item>, onStatusChange: (Item, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        todoList.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Row(modifier = Modifier.padding(12.dp)) {
                    TodoCheckbox(
                        checked = item.status == TodoStatus.COMPLETED,
                        onCheckedChange = { checked ->
                            onStatusChange(item, checked)
                        })
                    TodoItem(item = item)
                }
            }
        }
    }
}


@Preview
@Composable
private fun TodoListPreview() {
    TodoList(
        todoList = TodoItemFactory.makeTodoList(),
        onStatusChange = { _, _ -> }
    )

}