package dev.sangui.bigwormsattractor.view

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.java.KoinJavaComponent.inject

private val sandWormViewModel: SandWormViewModel by inject(SandWormViewModel::class.java)

@Composable
fun SandWormScreen() {
    var isOpened by remember {
        mutableStateOf(false)
    }

    BoxWithConstraints(
        Modifier.fillMaxHeight()
    ) {
        val maxHeightSize = maxHeight
        val maxWidthSize = maxWidth
        val tubeHeight = maxHeightSize * 0.2f

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.BottomCenter,
        ) {

            Column {
                val variableHeightTube by animateDpAsState(
                    targetValue = if (isOpened) tubeHeight else 0.0.dp,
                )

                Spacer(
                    modifier = Modifier
                        .width(maxWidthSize * 0.8f)
                        .clip(RoundedCornerShape(15.dp))
                        .align(Alignment.CenterHorizontally)
                        .height(maxHeightSize * 0.3f)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .background(color = Color.Black)
                        .height(variableHeightTube)
                        .width(maxWidthSize * 0.3f)
                        .align(Alignment.CenterHorizontally),
                )

                Spacer(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(10.dp))
                        .width(maxWidthSize * 0.90f)
                        .height(maxHeightSize * 0.075f)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .width(maxWidthSize * 0.8f)
                        .height(maxHeightSize * 0.20f)
                        .align(Alignment.CenterHorizontally)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .width(maxWidthSize * 0.5f)
                        .height(maxHeightSize * 0.10f)
                        .align(Alignment.CenterHorizontally)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .width(maxWidthSize * 0.25f)
                        .height(maxHeightSize * 0.1f)
                        .align(Alignment.CenterHorizontally)
                        .background(color = Color.Black),
                )
            }
        }

    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = {
                sandWormViewModel.triggerVibration()
                isOpened = !isOpened
            },
        ) {
            Text(text = "Activated")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShowScreen() {
    SandWormScreen()
}
