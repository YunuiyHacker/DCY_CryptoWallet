package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

sealed class ConfirmSeedPhraseEvent() {
    data class ClickThirdPhrase(val title: String) : ConfirmSeedPhraseEvent()
    data class ClickSeventhPhrase(val title: String) : ConfirmSeedPhraseEvent()
    data class ClickTwelfthPhrase(val title: String) : ConfirmSeedPhraseEvent()
    object GetWords: ConfirmSeedPhraseEvent()
}