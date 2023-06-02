package com.skx.devui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDanger(
    show: Boolean = true,
    onDismissRequest: () -> Unit = {},
    title: String = "Error",
    message: String = "Something went wrong",
) {
    var showDialog by remember { mutableStateOf(show) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismissRequest(); showDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        contentDescription = "Alert Icon",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h6
                    )
                }
            },
            text = {
                Text(
                    text = message,
                    style = MaterialTheme.typography.body2,
                    color = Color.Red
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { onDismissRequest(); showDialog = false },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Text(
                        text = "Ok",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewAlertWithRedColor() {
    AlertDanger(
        show = true,
        onDismissRequest = {},
        title = "Alert Title",
        message = "Alert Message"
    )
}
