package com.skx.devui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CartBadge() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray.copy(0.1f)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.padding(16.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier.padding(top = 8.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "3",
                        modifier = Modifier
                            .size(16.dp)
                            .background(Color.Red)
                            .padding(4.dp),
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier.size(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "🛒",
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CartBadgePreview() {
    CartBadge()
}
