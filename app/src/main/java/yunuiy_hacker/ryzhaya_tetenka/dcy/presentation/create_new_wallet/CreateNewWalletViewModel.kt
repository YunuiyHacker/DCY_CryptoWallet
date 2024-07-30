package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateNewWalletViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(CreateNewWalletState())

    fun onEvent(event: CreateNewWalletEvent) {
        when (event) {
            is CreateNewWalletEvent.ToPage -> {
                when (state.currentPage) {
                    0 -> state.currentProcess = 0
                    1, 2, 3 -> state.currentProcess = 1
                    4, 5 -> state.currentProcess = 2
                }
            }
        }
    }
}