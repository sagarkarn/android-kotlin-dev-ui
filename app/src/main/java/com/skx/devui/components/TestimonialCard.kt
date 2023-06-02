package com.skx.devui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TestimonialCard() {
    Card(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        elevation = 8.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp).wrapContentHeight()
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = MaterialTheme.shapes.large)
                    .border(2.dp, Color(0xFF3F51B5), shape = MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Design Tools",
                    style = MaterialTheme.typography.h5,
                    color = Color(0xFF37474F),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae dolores deserunt ea doloremque natus error, rerum quas odio quaerat nam ex commodi hic, suscipit in a veritatis pariatur minus consequuntur!",
                    style = MaterialTheme.typography.body2,
                    color = Color(0xFF607D8B)
                )
                Text(
                    text = "John Doe",
                    style = MaterialTheme.typography.h6,
                    color = Color(0xFF3F51B5),
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Preview
@Composable
fun TestimonialCardPreview() {
    TestimonialCard()
}
