package com.skx.devui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun ProfileComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(180.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(com.skx.devui.R.drawable.profile_image),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "John Doe",
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.h6,
                    textDecoration = TextDecoration.None
                )
                Text(
                    text = "John@Doe.com",
                    modifier = Modifier.padding(top = 2.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.body2,
                    textDecoration = TextDecoration.None
                )
                Button(
                    onClick = { /* Handle account management click */ },
                    modifier = Modifier.padding(top = 16.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text(
                        text = "Manage your Account",
                        style = MaterialTheme.typography.button,
                        color = Color.White
                    )
                }
            }
        }

        Button(
            onClick = { /* Handle campaigns click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(70.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(com.skx.devui.R.drawable.profile_image),
                    contentDescription = "Campaigns Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Campaigns",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Gray,
                        textDecoration = TextDecoration.None
                    )
                    Text(
                        text = "View your campaigns",
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        textDecoration = TextDecoration.None
                    )
                }
            }
        }

        Button(
            onClick = { /* Handle donations click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(70.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(com.skx.devui.R.drawable.profile_image),
                    contentDescription = "Donations Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Donations",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Gray,
                        textDecoration = TextDecoration.None
                    )
                    Text(
                        text = "View your last donations",
                        style = MaterialTheme.typography.body2,
                        color = Color.Gray,
                        textDecoration = TextDecoration.None
                    )
                }
            }
        }

        Button(
            onClick = { /* Handle logout click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(com.skx.devui.R.drawable.ic_logout),
                    contentDescription = "Logout Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Logout",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Gray,
                    textDecoration = TextDecoration.None
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    }
}
