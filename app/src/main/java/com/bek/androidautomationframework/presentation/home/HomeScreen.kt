package com.bek.androidautomationframework.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bek.androidautomationframework.presentation.theme.AndroidAutomationFrameworkTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    modifier: Modifier = Modifier
){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            Text(
                text = uiState.title,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = uiState.subtitle,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            PermissionStatusCard (
                title = "Accessibility Service",
                enabled = uiState.accessibilityEnabled
            )

            PermissionStatusCard(
                title = "Overlay Permission",
                enabled = uiState.overlayPermissionGranted
            )
        }

    }
}


@Composable
private fun PermissionStatusCard(
    title : String,
    enabled : Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = if (enabled) "Enabled" else "not Enabled",
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview(){
    AndroidAutomationFrameworkTheme {
        HomeScreen(
            uiState = HomeUiState()
        )
    }
}
