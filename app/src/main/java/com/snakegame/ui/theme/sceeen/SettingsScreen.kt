package com.snakegame.ui.theme.sceeen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snakegame.ui.theme.sceeen.viewmodel.SettingsSharedViewModel

@Composable
fun SettingsScreen(
    paddingValues: PaddingValues = PaddingValues(),
    sharedViewModel: SettingsSharedViewModel,
    onClickBack: () -> Unit
) {
    // Получаем текущие настройки из SharedViewModel
    val currentSpeed by sharedViewModel.speed.collectAsState()
    val currentCanHitWall by sharedViewModel.canHitWall.collectAsState()

    // Локальные состояния для UI, инициализированные текущими значениями из ViewModel
    var speed by remember { mutableStateOf(currentSpeed) }
    var canHitWall by remember { mutableStateOf(currentCanHitWall) }

    SettingsScreenUI(
        paddingValues = paddingValues,
        speed = speed,
        onSpeedChange = { speed = it },
        canHitWall = canHitWall,
        onCanHitWallChange = { canHitWall = it },
        onClickBack = {
            // Обновляем настройки в SharedViewModel перед возвратом
            sharedViewModel.updateSettings(speed, canHitWall)
            onClickBack()
        }
    )
}

@Composable
fun SettingsScreenUI(
    paddingValues: PaddingValues,
    speed: Int,
    onSpeedChange: (Int) -> Unit,
    canHitWall: Boolean,
    onCanHitWallChange: (Boolean) -> Unit,
    onClickBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onClickBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Назад"
                )
            }
            Text(
                text = "Настройки",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text("Скорость: $speed")
        Slider(
            value = speed.toFloat(),
            onValueChange = { onSpeedChange(it.toInt()) },
            valueRange = 1f..10f,
            steps = 8
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Врезаться в стены")
            Spacer(Modifier.width(8.dp))
            Switch(
                checked = canHitWall,
                onCheckedChange = onCanHitWallChange
            )
        }
    }
}