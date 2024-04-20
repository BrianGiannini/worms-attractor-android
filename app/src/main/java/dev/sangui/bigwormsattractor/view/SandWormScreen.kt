package dev.sangui.bigwormsattractor.view

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    val isToggling by sandWormViewModel.isToggling.collectAsState()
    val toggleState by sandWormViewModel.toggleState.collectAsState()
    val buttonText = if (isToggling) "Deactivate" else "Activate"

    BoxWithConstraints(
        Modifier.fillMaxHeight()
    ) {
        val maxHeightSize = maxHeight
        val maxWidthSize = maxWidth
        val tubeHeight = maxHeightSize * 0.15f

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.BottomCenter,
        ) {

            Column {
                val variableHeightTube by animateDpAsState(
                    targetValue = if (toggleState) tubeHeight else 0.0.dp,
                )

                Spacer(
                    modifier = Modifier
                        .padding(bottom = 0.2.dp)
                        .clip(
                            RoundedCornerShape(topStart = 100.dp, topEnd = 100.dp)
                        )
                        .align(Alignment.CenterHorizontally)
                        .height(maxHeightSize * 0.40f)
                        .width(maxWidthSize * 0.8f)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .background(color = Color.Black)
                        .height(variableHeightTube)
                        .width(maxWidthSize * 0.25f)
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
                        .clip(
                            CutCornerShape(bottomStart = 90.dp, bottomEnd = 90.dp)
                        )
                        .width(maxWidthSize * 0.8f)
                        .height(maxHeightSize * 0.20f)
                        .align(Alignment.CenterHorizontally)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .clip(
                            CutCornerShape(
                                bottomStart = 15.dp, bottomEnd = 15.dp
                            )
                        )
                        .width(maxWidthSize * 0.35f)
                        .height(maxHeightSize * 0.10f)
                        .align(Alignment.CenterHorizontally)
                        .background(color = Color.Black),
                )

                Spacer(
                    modifier = Modifier
                        .width(maxWidthSize * 0.20f)
                        .height(maxHeightSize * 0.05f)
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
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            onClick = {
                if (isToggling) {
                    sandWormViewModel.stopPeriodicThumperAnimation()
                } else {
                    sandWormViewModel.startPeriodicThumperAnimation()
                }
            },
        ) {
            Text(text = buttonText)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShowScreen() {
    SandWormScreen()
}
