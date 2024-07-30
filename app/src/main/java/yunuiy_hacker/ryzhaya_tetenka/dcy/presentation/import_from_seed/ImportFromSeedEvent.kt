package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed

sealed class ImportFromSeedEvent() {
    data class SeedChange(val seed: String) : ImportFromSeedEvent()
    data class NewPasswordChange(val newPassword: String) : ImportFromSeedEvent()
    data class ConfirmPasswordChange(val confirmPassword: String) : ImportFromSeedEvent()
    object SeedVisibleChange : ImportFromSeedEvent()
    object NewPasswordVisibleChange : ImportFromSeedEvent()
    object ConfirmPasswordVisibleChange : ImportFromSeedEvent()
    object SignInWithFaceIdChange : ImportFromSeedEvent()
}