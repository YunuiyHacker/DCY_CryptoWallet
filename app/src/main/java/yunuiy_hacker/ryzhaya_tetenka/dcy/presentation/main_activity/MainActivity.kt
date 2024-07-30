package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.NavGraph
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.OnboardingScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.OnboardingViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DCYTheme
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.splashCondition
            }
        }

        setContent {
            DCYTheme {
                Surface(color = DarkBackground) {
                    NavGraph(startDestination = mainViewModel.startDestination)
                }
            }
        }
    }
}