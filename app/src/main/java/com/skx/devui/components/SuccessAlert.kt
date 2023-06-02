package com.skx.devui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.rememberAsyncImagePainter

@Composable
fun AlertSuccess(
    show: Boolean = true,
    onDismissRequest: () -> Unit = {},
    title: String = "Success",
    message: String = "success",
) {
    var showDialog by remember { mutableStateOf(show) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismissRequest(); showDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Success Icon",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Green
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
                    color = Color.Green
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { onDismissRequest(); showDialog = false },
                ) {
                    Text(
                        text = "Ok",
                        style = MaterialTheme.typography.button
                    )
                }
            },
        )
    }
}

@Preview
@Composable
fun PreviewSuccessAlert() {
    AlertSuccess(
        show = true,
        onDismissRequest = {},
        title = "Alert Title",
        message = "This is some informational text that you can use to show some success content"
    )
}
