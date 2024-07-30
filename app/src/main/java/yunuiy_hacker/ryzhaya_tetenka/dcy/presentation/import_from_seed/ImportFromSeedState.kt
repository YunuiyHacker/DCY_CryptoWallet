package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ImportFromSeedState() {
    var seedPhrase by mutableStateOf("")
    var newPassword by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var seedPhraseVisible by mutableStateOf(true)
    var newPasswordVisible by mutableStateOf(true)
    var confirmPasswordVisible by mutableStateOf(true)
    var signInWithFaceId by mutableStateOf(false)
    var isValid by mutableStateOf(false)
}