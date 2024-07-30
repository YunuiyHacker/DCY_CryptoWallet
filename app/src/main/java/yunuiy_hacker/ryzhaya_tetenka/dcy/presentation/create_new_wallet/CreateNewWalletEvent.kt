package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet

sealed class CreateNewWalletEvent() {
    data class ToPage(val index: Int) : CreateNewWalletEvent()
}