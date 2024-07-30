package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.main_activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry.AppEntryUseCase
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appEntryUseCase: AppEntryUseCase) :
    ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.OnboardingScreen.route)
        private set

    init {
        appEntryUseCase.readAppEntry().onEach { value ->
            startDestination = if (value) {
                Route.WalletSetupScreen.route
            } else Route.OnboardingScreen.route
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}