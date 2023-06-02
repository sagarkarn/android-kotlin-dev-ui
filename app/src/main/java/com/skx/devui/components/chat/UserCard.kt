package com.skx.devui.components.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skx.devui.components.Avatar

@Composable
fun UserMessageListCard(
    modifier: Modifier = Modifier,
    title: String = "John Doe",
    message: String = "How are you doing?",
    time: String = "10:00 AM"
) {
    Card(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Avatar()
            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                ) {
                    UserName(title)
                    UserMessage(message)
                }

                Text(
                    text = time,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Top)
                )
            }
        }
    }
}

@Composable
fun UserName(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}

@Composable
fun UserMessage(message: String){
    Text(
        text = message,
        fontSize = 14.sp,
        color = Color.Gray,
        maxLines = 1
    )
}


@Preview
@Composable
fun PreviewMyComponent() {
    UserMessageListCard()
}
