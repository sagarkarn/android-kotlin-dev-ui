package com.skx.devui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.skx.devui.R

@Composable
fun ChatNewMessageBox() {
    val messageState = remember { mutableStateOf(TextFieldValue()) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 4.dp)

        ) {
            TextField(
                value = messageState.value,
                onValueChange = { messageState.value = it },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent),
                trailingIcon = {
                    IconButton(
                        onClick = { /* Handle submit button click */ },
                        modifier = Modifier.padding()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Send",
                            tint = Color.Blue
                        )
                    }
                },
                leadingIcon = {
                    Row() {
                        IconButton(
                            onClick = { /* Handle submit button click */ },
                            modifier = Modifier.padding()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.smiley),
                                contentDescription = "smiley",
                                tint = Color.DarkGray
                            )
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_insert_photo_24),
                                contentDescription = "Send",
                                tint = Color.DarkGray
                            )
                        }
                    }
                },
            )
    }
}
