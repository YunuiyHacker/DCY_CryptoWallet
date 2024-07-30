package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password

sealed class CreatePasswordEvent() {
    data class NewPasswordChange(val newPassword: String) : CreatePasswordEvent()
    data class ConfirmNewPasswordChange(val confirmNewPassword: String) : CreatePasswordEvent()
    object NewPasswordVisibilityChange : CreatePasswordEvent()
    object ConfirmNewPasswordVisibilityChange : CreatePasswordEvent()
    object SignInWithFaceIdChange : CreatePasswordEvent()
    object IUnderstandChange: CreatePasswordEvent()
}