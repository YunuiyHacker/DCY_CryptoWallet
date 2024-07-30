package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreatePasswordViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(CreatePasswordState())

    fun onEvent(event: CreatePasswordEvent) {
        when (event) {
            is CreatePasswordEvent.NewPasswordChange -> {
                state.newPassword = event.newPassword
                if (state.newPassword.length >= 8) {
                    if (state.newPassword.contains(Regex("[A-Z]")) && state.newPassword.contains(
                            Regex("[0-9]")
                        ) && state.newPassword.contains(Regex("""\W"""))
                    ) state.newPasswordStrength = 2
                    else state.newPasswordStrength = 1
                } else {
                    state.newPasswordStrength = 0
                }
            }

            is CreatePasswordEvent.ConfirmNewPasswordChange -> {
                state.confirmNewPassword = event.confirmNewPassword
            }

            is CreatePasswordEvent.NewPasswordVisibilityChange -> {
                state.newPasswordVisible = !state.newPasswordVisible
            }

            is CreatePasswordEvent.ConfirmNewPasswordVisibilityChange -> {
                state.confirmNewPasswordVisible = !state.confirmNewPasswordVisible
            }

            is CreatePasswordEvent.SignInWithFaceIdChange -> {
                state.signInWithFaceId = !state.signInWithFaceId
            }

            is CreatePasswordEvent.IUnderstandChange -> {
                state.iUnderstand = !state.iUnderstand
            }
        }

        if (state.newPasswordStrength == 2 && state.newPassword == state.confirmNewPassword && state.iUnderstand) state.isValid =
            true
        else state.isValid = false
    }
}