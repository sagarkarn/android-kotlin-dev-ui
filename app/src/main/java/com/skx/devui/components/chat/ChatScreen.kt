package com.skx.devui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar()
        Messages(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth()
                .weight(1f))
        ChatNewMessageBox()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileInfo()
        Actions()
    }
}

@Composable
fun ProfileInfo() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(com.skx.devui.R.drawable.profile_image),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Anderson Vanhron",
                style = TextStyle(fontSize = 24.sp, color = Color.Gray)
            )
            Text(
                text = "Junior Developer",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )
        }
    }
}

@Composable
fun Actions() {
    Row {
        IconButton(
            onClick = { /* Perform action */ },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                painter = painterResource(com.skx.devui.R.drawable.ic_check),
                contentDescription = null,
                tint = Color.Gray
            )
        }
        IconButton(
            onClick = { /* Perform action */ },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                painter = painterResource(com.skx.devui.R.drawable.ic_message),
                contentDescription = null,
                tint = Color.Gray
            )
        }
        IconButton(
            onClick = { /* Perform action */ },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                painter = painterResource(com.skx.devui.R.drawable.ic_settings),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun Messages(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        ChatMessage(isSentByUser = false, text = "Can be verified on any platform using docker", time = "10:00 AM")
        ChatMessage(isSentByUser = true, text = "Your error message says permission denied, npm global installs must be given root privileges.", time = "10:01 AM")
        // Add more chat messages here
    }
}

@Composable
fun ChatMessage(isSentByUser: Boolean, text: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = if (isSentByUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isSentByUser) {
            Image(
                painter = painterResource(com.skx.devui.R.drawable.profile_image),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }
        Column(
            modifier = Modifier
                .padding(start = if (isSentByUser) 0.dp else 8.dp, end = if (isSentByUser) 8.dp else 0.dp)
                .background(
                    color = if (isSentByUser) Color.Blue else Color(0xFFEAEAEA),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = text,
                style = TextStyle(fontSize = 16.sp, color = if (isSentByUser) Color.White else Color.Black)
            )
            Text(
                text = time,
                style = TextStyle(fontSize = 12.sp, color = if (isSentByUser) Color.LightGray else Color.DarkGray)
            )
        }
        if (isSentByUser) {
            Image(
                painter = painterResource(com.skx.devui.R.drawable.profile_image),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun InputBar() {
    ChatNewMessageBox()
}
