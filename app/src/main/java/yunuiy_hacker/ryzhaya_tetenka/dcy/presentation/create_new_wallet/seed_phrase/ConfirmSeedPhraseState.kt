package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ConfirmSeedPhraseState() {
    var seedPhrase: MutableList<String> = mutableListOf()
    var seedsSize by mutableStateOf(3)
    var currentSeed by mutableStateOf(0)
    var seedWords = mutableListOf("")
    var thirdWord by mutableStateOf("")
    var seventhWord by mutableStateOf("")
    var twelfthWord by mutableStateOf("")
    var seedWordsPassed by mutableStateOf(true)
    var valid by mutableStateOf(true)
}