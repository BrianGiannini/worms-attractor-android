package dev.sangui.bigwormsattractor.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import org.koin.java.KoinJavaComponent.inject

private val sandWormViewModel: SandWormViewModel by inject(SandWormViewModel::class.java)

@Composable
fun SandWormScreen() {

    Column {
        Button(
            onClick = { sandWormViewModel.triggerVibration() },
        ) {

        }
    }
}