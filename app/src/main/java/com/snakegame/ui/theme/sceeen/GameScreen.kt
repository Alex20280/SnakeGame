package com.snakegame.ui.theme.sceeen

import android.app.GameState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.snakegame.ui.theme.sceeen.viewmodel.SettingsSharedViewModel


@Composable
fun GameScreen(
    paddingValues: PaddingValues,
    settingsSharedViewModel: SettingsSharedViewModel
    //onClickBackButton: () -> Unit
) {
    val speed = settingsSharedViewModel.speed.collectAsState()
    val canHitWall = settingsSharedViewModel.canHitWall.collectAsState()
    val score = settingsSharedViewModel.score.collectAsState()

    GameScreenUI(
        paddingValues = paddingValues,
        speed = speed.value,
        canHitWall = canHitWall.value,
        score = score.value
        //onClickBackButton = { onClickBackButton.invoke() }
    )
}

@Composable
fun GameScreenUI(
    paddingValues: PaddingValues,
    onPauseClick: () -> Unit = {},
    onMoveUp: () -> Unit = {},
    onMoveDown: () -> Unit = {},
    onMoveLeft: () -> Unit = {},
    onMoveRight: () -> Unit = {},
    canHitWall: Boolean,
    speed: Int,
    score: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 🔝 Top bar with Speed and Score — more top padding
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp), // more top padding here
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Face, contentDescription = "Speed")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Speed: $speed")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = "Score")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Score: $score")
                }
            }

            // 🟩 Snake Game Field
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .border(2.dp, Color.Gray)
            ) {
                // Game content here
            }

            // 🎮 Control Buttons + Pause Button — reduced top padding
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(onClick = onMoveUp) {
                        Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Up")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = onMoveLeft) {
                            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Left")
                        }
                        Spacer(modifier = Modifier.width(48.dp))
                        IconButton(onClick = onMoveRight) {
                            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Right")
                        }
                    }
                    IconButton(onClick = onMoveDown) {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Down")
                    }
                }

                IconButton(
                    onClick = onPauseClick,
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Icon(Icons.Default.Check, contentDescription = "Pause")
                }
            }
        }
    }
}