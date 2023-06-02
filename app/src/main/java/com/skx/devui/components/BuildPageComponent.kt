package com.skx.devui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BuildPageComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .width(500.dp)
                .padding(vertical = 12.dp, horizontal = 6.dp)
                .background(Color(0xFF1B2042)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Build your page",
                modifier = Modifier.padding(bottom = 2.dp),
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Complete actions to unlock new features along the way.\n" +
                        "On average, completed pages get 30% more traffic.",
                modifier = Modifier.padding(bottom = 12.dp),
                style = MaterialTheme.typography.body1
            )
            Row(modifier = Modifier.padding(bottom = 2.dp), verticalAlignment = Alignment.Bottom) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(15.dp)
                        .background(Color.Blue)
                        .border(shape = RoundedCornerShape(percent = 50), border = BorderStroke(1.dp, Color.Transparent))
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(15.dp)
                        .background(Color.Blue)
                        .border(shape = RoundedCornerShape(percent = 50), border = BorderStroke(1.dp, Color.Transparent))
                )
                // Repeat the remaining spans for other colors...
            }
            Text(
                text = "3 remaining to complete",
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
