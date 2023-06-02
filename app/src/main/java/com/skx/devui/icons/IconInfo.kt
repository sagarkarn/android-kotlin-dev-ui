import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconInfo(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    color: Color = MaterialTheme.colors.contentColorFor(MaterialTheme.colors.surface),
) {
    Canvas(modifier = modifier.size(size)) {
        val strokeWidth = 2f
        val centerX = size.toPx() / 2
        val centerY = size.toPx() / 2
        val radius = (size.toPx() - strokeWidth) / 2

        drawCircle(
            color = color,
            radius = radius,
            style = Stroke(width = strokeWidth)
        )

        val curveRadius = radius - strokeWidth
        val curveOffset = size.toPx() / 4

        translate(centerX, centerY - curveOffset) {
            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(-curveRadius, -curveRadius),
                size = Size(curveRadius * 2, curveRadius * 2),
                style = Stroke(width = strokeWidth)
            )
        }

        translate(centerX, centerY + curveOffset) {
            drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(0f, curveOffset - strokeWidth / 2),
                strokeWidth = strokeWidth
            )
        }
    }
}
