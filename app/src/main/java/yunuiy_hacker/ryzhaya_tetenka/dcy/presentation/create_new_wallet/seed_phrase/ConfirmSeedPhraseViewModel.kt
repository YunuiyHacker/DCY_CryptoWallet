package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmSeedPhraseViewModel @Inject constructor() : ViewModel() {
    val state by mutableStateOf(ConfirmSeedPhraseState())

    fun onEvent(event: ConfirmSeedPhraseEvent) {
        when (event) {
            is ConfirmSeedPhraseEvent.ClickThirdPhrase -> {
                state.thirdWord = event.title
                state.valid = true
            }

            is ConfirmSeedPhraseEvent.ClickSeventhPhrase -> {
                state.seventhWord = event.title
                state.valid = true
            }

            is ConfirmSeedPhraseEvent.ClickTwelfthPhrase -> {
                state.twelfthWord = event.title
                if (state.thirdWord == state.seedPhrase[2] && state.seventhWord == state.seedPhrase[6] && state.twelfthWord == state.seedPhrase[11]) {
                    state.valid = true
                    state.seedWordsPassed = true
                } else {
                    state.valid = false
                    state.seedWordsPassed = false
                }
            }

            is ConfirmSeedPhraseEvent.GetWords -> {
                state.seedWords = mutableListOf()
                while (state.seedWords.size < 6) {
                    val result: MutableList<String> = mutableListOf()
                    while (result.size < 6) {
                        val randomWord = state.seedPhrase[(0..11).random()]
                        if (!result.contains(randomWord))
                            result.add(randomWord)
                        if (result.size == 4) {
                            when (state.currentSeed) {
                                0 -> {
                                    if (!result.contains(state.thirdWord))
                                        result.add(state.seedPhrase[2])
                                }

                                1 -> {
                                    if (!result.contains(state.seventhWord))
                                        result.add(state.seedPhrase[6])
                                }

                                2 -> {
                                    if (!result.contains(state.twelfthWord))
                                        result.add(state.seedPhrase[11])
                                }
                            }
                        }
                    }
                    state.seedWords = result
                }
            }
        }
    }
}