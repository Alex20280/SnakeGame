package com.snakegame.ui.theme.sceeen

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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun GameScreen(
    paddingValues: PaddingValues,
    //onClickBackButton: () -> Unit
) {

    GameScreenUI(
        paddingValues = paddingValues,
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
    onMoveRight: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Snake Game Field
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
                    .padding(16.dp)
                    .border(2.dp, Color.Gray)
            ) {
                // Game content goes here
                Text(
                    text = "Snake Game Field",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // Control Buttons + Pause Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // D-pad
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(onClick = onMoveUp) {
                        Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Up")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onMoveLeft) {
                            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Left")
                        }
                        Spacer(modifier = Modifier.width(48.dp)) // Empty center
                        IconButton(onClick = onMoveRight) {
                            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Right")
                        }
                    }
                    IconButton(onClick = onMoveDown) {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Down")
                    }
                }

                // Pause button in bottom-left corner
                IconButton(
                    onClick = onPauseClick,
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Icon(Icons.Default.AddCircle, contentDescription = "Pause")
                }
            }
        }
    }
}