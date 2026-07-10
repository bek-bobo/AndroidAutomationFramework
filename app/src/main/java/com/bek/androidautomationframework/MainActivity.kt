package com.bek.androidautomationframework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bek.androidautomationframework.presentation.home.HomeScreen
import com.bek.androidautomationframework.presentation.home.HomeViewModel
import com.bek.androidautomationframework.presentation.theme.AndroidAutomationFrameworkTheme

class MainActivity : ComponentActivity() {

    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AndroidAutomationFrameworkTheme {
                val uiState by homeViewModel.uiState.collectAsState()

                HomeScreen(
                    uiState = uiState
                )
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidAutomationFrameworkTheme {
        Greeting("Android")
    }
}