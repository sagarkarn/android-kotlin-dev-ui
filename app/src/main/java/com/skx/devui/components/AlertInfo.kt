import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertInfo(
    show: Boolean = true,
    onDismissRequest: () -> Unit = {},
    title: String = "Alert",
    message: String = "Alert Message"
) {
    var showDialog by remember { mutableStateOf(show) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismissRequest(); showDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Kotlin Icon",
                        modifier = Modifier.size(24.dp)
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
                    style = MaterialTheme.typography.body2
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
            },

        )
    }
}

@Preview
@Composable
fun PreviewAlertWithKotlinIcon() {
    AlertInfo(
        show = true,
        onDismissRequest = {},
        title = "Kotlin",
        message = "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference."
    )
}
