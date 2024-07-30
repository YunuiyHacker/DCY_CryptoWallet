package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry.AppEntryUseCase
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val appEntryUseCase: AppEntryUseCase) :
    ViewModel() {
    val state by mutableStateOf(OnboardingState())

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.OnClick -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()
        }
    }
}