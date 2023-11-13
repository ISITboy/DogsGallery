package com.example.dogsphotos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.dogsphotos.presentation.mainActivity.MainViewModel
import com.example.dogsphotos.presentation.nvgraph.NavGraph
import com.example.dogsphotos.presentation.onboarding.OnBoardingScreen
import com.example.dogsphotos.presentation.onboarding.OnBoardingViewModel
import com.example.dogsphotos.presentation.onboarding.components.OnBoardingPage
import com.example.dogsphotos.ui.theme.DogsPhotosTheme
import com.example.domain.usecases.app_entry.AppEntryUsesCases
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
        }
        installSplashScreen()
        setContent {
            DogsPhotosTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    Log.d("MyLog","MainActivity")
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}

