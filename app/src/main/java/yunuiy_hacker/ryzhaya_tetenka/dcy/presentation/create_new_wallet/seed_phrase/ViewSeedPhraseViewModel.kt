package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.seed.SeedPhraseUseCase
import javax.inject.Inject

@HiltViewModel
class ViewSeedPhraseViewModel @Inject constructor(seedPhraseUseCase: SeedPhraseUseCase) :
    ViewModel() {
    var seedVisible by mutableStateOf(false)
    val seedPhrase: MutableList<String>

    init {
        seedPhrase = seedPhraseUseCase.invoke()
    }
}