package com.snakegame.ui.theme.sceeen

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreenScreen(
    paddingValues: PaddingValues,
    onStartClick: () -> Unit,
    onSettingsClick: () -> Unit
) {

    WelcomeScreenScreenUI(
        paddingValues = paddingValues,
        onStartClick = onStartClick,
        onSettingsClick = onSettingsClick
    )
}


@Composable
fun WelcomeScreenScreenUI(
    paddingValues: PaddingValues,
    onStartClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { onStartClick.invoke() },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text(text = "Start")
            }

            Button(
                onClick = { onSettingsClick.invoke() },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text(text = "Settings")
            }

            Button(
               // onClick = { onExitClick.invoke() },
                onClick = {(context as? Activity)?.finish() },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text(text = "Exit")
            }
        }
    }
}