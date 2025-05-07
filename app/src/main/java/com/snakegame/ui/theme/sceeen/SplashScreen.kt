package com.snakegame.ui.theme.sceeen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreenScreen(
    paddingValues: PaddingValues,
    navigate: () -> Unit
) {

    SplashScreenScreenUI(
        paddingValues = paddingValues,
        navigate = navigate
    )
}

@Composable
fun SplashScreenScreenUI(
    paddingValues: PaddingValues,
    navigate: () -> Unit
) {
    val progress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 5000, easing = LinearEasing)
        )
        navigate()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0F0C0))
            .padding(paddingValues),
        contentAlignment = Alignment.BottomCenter
    ) {
        LinearProgressIndicator(
            progress = progress.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(50))
                .height(12.dp),
            color = Color.Green,
            trackColor = Color.LightGray
        )
    }
}