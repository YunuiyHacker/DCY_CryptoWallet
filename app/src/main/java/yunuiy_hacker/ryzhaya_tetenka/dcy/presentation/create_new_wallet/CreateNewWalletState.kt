package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CreateNewWalletState {
    var processSize by mutableStateOf(3)
        private set
    var currentProcess by mutableStateOf(0)
    var pages by mutableStateOf(6)
    var currentPage by mutableStateOf(0)
    var firstPageValid by mutableStateOf(false)
    var secondPageValid by mutableStateOf(false)
    var thirdPageValid by mutableStateOf(true)
    var thirdPagePassed by mutableStateOf(true)
    var seedPhrase = mutableListOf("")
    var seedPage by mutableStateOf(0)
}