package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CreatePasswordState() {
    var newPassword by mutableStateOf("")
    var confirmNewPassword by mutableStateOf("")
    var newPasswordStrength by mutableStateOf(0)
    var newPasswordVisible by mutableStateOf(true)
    var confirmNewPasswordVisible by mutableStateOf(true)
    var signInWithFaceId by mutableStateOf(false)
    var iUnderstand by mutableStateOf(false)
    var isValid by mutableStateOf(false)
}