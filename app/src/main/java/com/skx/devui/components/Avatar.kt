package com.skx.devui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlin.math.round
import kotlin.math.roundToInt

enum class AvatarShape {
    Circle,
    Rounded,
    Square
}


@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    size: Dp = 40.dp,
    borderStroke: BorderStroke? = null,
    shape: AvatarShape = AvatarShape.Circle,
    elevation: Dp = 4.dp,
    imageVector: ImageVector? = null,
    contentDescription: String? = null,
    vectorPainter: VectorPainter? = null,
    painter: Painter? = null,
    src: String? = null,
    placeholder: ImageVector = Icons.Default.Person,
) {

    val imageShape = when (shape) {
        AvatarShape.Circle -> RoundedCornerShape(percent = 50)
        AvatarShape.Rounded -> RoundedCornerShape(4.dp)
        AvatarShape.Square -> RoundedCornerShape(0.dp)
    }

    Card(
        modifier = modifier.size(size),
        shape = imageShape,
        elevation = elevation,
        border = borderStroke,
    ) {
        if (imageVector != null) {
            Image(
                modifier = imageModifier,
                imageVector = imageVector,
                contentDescription = contentDescription,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                contentScale = ContentScale.Crop,
            )
        } else if (vectorPainter != null) {
            Image(
                modifier = imageModifier,
                painter = vectorPainter,
                contentDescription = contentDescription,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                contentScale = ContentScale.Crop,
            )
        } else if (painter != null) {
            Image(
                modifier = imageModifier,
                painter = painter,
                contentDescription = contentDescription,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                contentScale = ContentScale.Crop,
            )
        } else if (src != null) {
            AsyncImage(
                model = src,
                contentDescription = null,
                placeholder = rememberVectorPainter(placeholder)
            )
        }
        else {
            Image(
                modifier = imageModifier,
                imageVector = placeholder,
                contentDescription = contentDescription,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview
@Composable
fun AvatarPreview() {
    Avatar(modifier = Modifier, size = 50.dp)
}