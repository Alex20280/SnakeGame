package com.snakegame.ui.theme.sceeen.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsSharedViewModel  : ViewModel() {
    // Настройки игры
    private val _speed = MutableStateFlow(1) // Значение скорости по умолчанию
    val speed: StateFlow<Int> = _speed.asStateFlow()

    private val _canHitWall = MutableStateFlow(false) // Значение canHitWall по умолчанию
    val canHitWall: StateFlow<Boolean> = _canHitWall.asStateFlow()

    // Другие общие состояния игры
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score.asStateFlow()

    // Функция для обновления настроек
    fun updateSettings(speed: Int, canHitWall: Boolean) {
        _speed.value = speed
        _canHitWall.value = canHitWall
    }

    // Функция для обновления счета
    fun updateScore(newScore: Int) {
        _score.value = newScore
    }

    // Функция для сброса игры
    fun resetGame() {
        _score.value = 0
        // Сброс других игровых состояний, если необходимо
    }
}