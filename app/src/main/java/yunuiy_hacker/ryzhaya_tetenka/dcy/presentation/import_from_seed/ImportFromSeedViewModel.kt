package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImportFromSeedViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(ImportFromSeedState())

    fun onEvent(event: ImportFromSeedEvent) {
        when (event) {
            is ImportFromSeedEvent.SeedChange -> {
                state.seedPhrase = event.seed
            }

            is ImportFromSeedEvent.ConfirmPasswordChange -> {
                state.confirmPassword = event.confirmPassword
            }

            is ImportFromSeedEvent.NewPasswordChange -> {
                state.newPassword = event.newPassword
            }

            is ImportFromSeedEvent.ConfirmPasswordVisibleChange -> {
                state.confirmPasswordVisible = !state.confirmPasswordVisible
            }

            is ImportFromSeedEvent.NewPasswordVisibleChange -> {
                state.newPasswordVisible = !state.newPasswordVisible
            }

            is ImportFromSeedEvent.SeedVisibleChange -> {
                state.seedPhraseVisible = !state.seedPhraseVisible
            }

            is ImportFromSeedEvent.SignInWithFaceIdChange -> {
                state.signInWithFaceId = !state.signInWithFaceId
            }
        }

        if (state.seedPhrase.trim()
                .split(' ').size == 12 && state.newPassword.length >= 8 && state.newPassword == state.confirmPassword
        ) {
            state.isValid = true
        } else state.isValid = false
    }
}