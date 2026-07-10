package com.bek.androidautomationframework.presentation.home


data class HomeUiState(
    val title: String = "Android Automation Framework",
    val subtitle: String = "Build and manage Android automation tools.",
    val accessibilityEnabled: Boolean = false,
    val overlayPermissionGranted: Boolean = false
)