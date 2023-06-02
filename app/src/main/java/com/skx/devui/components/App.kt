package com.skx.devui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.skx.devui.R

@Composable
fun App() {
    val searchState = remember { mutableStateOf("") }
    val users = remember {
        mutableStateListOf(
            User("John Doe", "john.doe@example.com", "https://source.unsplash.com/random/500x500/?face"),
            User("Jane Smith", "jane.smith@example.com", "https://source.unsplash.com/random/500x500/?face"),
            User("Robert Johnson", "robert.johnson@example.com", "https://source.unsplash.com/random/500x500/?face")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("App") },
                actions = {
                    IconButton(onClick = { /* Handle profile click */ }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = null)
                    }
                }
            )
        }
    ) { it1 ->
        Box(modifier = Modifier.padding(it1)) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = searchState.value,
                    onValueChange = { searchState.value = it },
                    placeholder = { Text("Search") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn {
                    items(users) { user ->
                        UserListItem(user)
                    }
                }
            }
        }

    }
}

@Composable
fun UserListItem(user: User) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(MaterialTheme.shapes.small)
                .border(1.dp, Color.Gray, MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = user.name,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = user.email,
                style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

data class User(val name: String, val email: String, val image: String)

@Preview
@Composable
fun AppPreview() {
    App()
}
