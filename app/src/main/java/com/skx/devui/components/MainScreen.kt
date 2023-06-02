package com.skx.devui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .background(Color(0xFFE5E5E5))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Get the most out of your mobile with the right subscription",
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "All devices come with free delivery or pickup as standard. See information on available shopping options for your location.",
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    style = MaterialTheme.typography.body2
                )

                Row(
                    modifier = Modifier
                        .padding(bottom = 16.dp).scrollable(orientation = Orientation.Vertical, state = rememberScrollState()),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SubscriptionCard(
                        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Ice_logo.svg/138px-Ice_logo.svg.png?20191213230535",
                        title = "Ice Mobile 10GB",
                        description = "Up to 100Mbit/s",
                        price = "299,-/month"
                    )

                    SubscriptionCard(
                        imageUrl = "https://www.dstny.se/app/uploads/telia_pp_rgb.png.webp",
                        title = "Telia Mobil 15GB",
                        description = "Unlimited calls",
                        price = "953,-/month"
                    )

                    SubscriptionCard(
                        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Telenor_Logo.svg/1600px-Telenor_Logo.svg.png",
                        title = "Telenor Next Fast",
                        description = "Up to 100Mbit/s",
                        price = "1028,-/month"
                    )
                }

                Button(
                    onClick = { /* TODO: Handle button click */ },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "See all subscriptions")
                }
            }
        }
    }
}

@Composable
fun SubscriptionCard(
    imageUrl: String,
    title: String,
    description: String,
    price: String
) {
    Card(
        modifier = Modifier
            .background(Color(0xFFFFFBEC))
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = com.skx.devui.R.drawable.ic_launcher_background), // Replace with your own drawable resource
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 8.dp),
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, style = MaterialTheme.typography.subtitle1)
                Text(text = description, style = MaterialTheme.typography.caption)
                Text(
                    text = price,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Button(
                onClick = { /* TODO: Handle button click */ },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .height(48.dp)
            ) {
                Text(text = "Add subscription")
            }
        }
    }
}
