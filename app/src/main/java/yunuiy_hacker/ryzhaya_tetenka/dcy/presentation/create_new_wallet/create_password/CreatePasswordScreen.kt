package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password

import android.text.Html
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password.components.OutlinedPasswordTextField
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.ImportFromSeedEvent
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.toAnnotateString
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.components.OutlinedTextField
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.HintGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.LinkBlue
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.TermsGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.GRADIENT_LIST_2

@Composable
fun CreatePasswordScreen(navController: NavController, viewModel: CreatePasswordViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Create Password",
            style = TextStyle(brush = Brush.horizontalGradient(GRADIENT_LIST_2)),
            fontFamily = archivo,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This password will unlock your Metamask wallet only on this service",
            color = TermsGray,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedPasswordTextField(
                value = viewModel.state.newPassword,
                onValueChange = { viewModel.onEvent(CreatePasswordEvent.NewPasswordChange(it)) },
                placeholderText = "New Password",
                trailingIconClick = { viewModel.onEvent(CreatePasswordEvent.NewPasswordVisibilityChange) },
                trailingIsChecked = viewModel.state.newPasswordVisible,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                passwordStrength = viewModel.state.newPasswordStrength
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = viewModel.state.confirmNewPassword,
                onValueChange = { viewModel.onEvent(CreatePasswordEvent.ConfirmNewPasswordChange(it)) },
                placeholderText = "New Password",
                trailingIconClick = { viewModel.onEvent(CreatePasswordEvent.ConfirmNewPasswordVisibilityChange) },
                trailingIsChecked = viewModel.state.confirmNewPasswordVisible,
                supportingText = "Must be at least 8 characters",
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                endTextField = true
            )
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sign in with Face ID?",
                    fontFamily = archivo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                )
                Switch(
                    checked = viewModel.state.signInWithFaceId,
                    onCheckedChange = { viewModel.onEvent(CreatePasswordEvent.SignInWithFaceIdChange) },
                    colors = SwitchDefaults.colors(
                        uncheckedBorderColor = Color.Transparent,
                        checkedBorderColor = Color.Transparent,
                        checkedTrackColor = Primary,
                        checkedThumbColor = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                Checkbox(
                    checked = viewModel.state.iUnderstand,
                    onCheckedChange = {
                        viewModel.onEvent(CreatePasswordEvent.IUnderstandChange)
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary,
                        checkmarkColor = Color.White
                    )
                )
                val someText = Html.fromHtml(
                    "I understand that DeGe cannot recover this password for me. <a href=\"https://google.com\">Learn more</a>",
                    Html.FROM_HTML_MODE_COMPACT
                )
                val annotatedString = someText.toAnnotateString(
                    baseSpanStyle = SpanStyle(
                        color = HintGray,
                        fontFamily = archivo,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    linkColor = LinkBlue,
                    useUnderline = false
                )
                ClickableText(
                    text = annotatedString,
                    modifier = Modifier.padding(start = 8.dp, top = 12.dp),
                    style = TextStyle(lineHeight = 24.sp)
                ) { offset ->
                    annotatedString.getStringAnnotations(Constants.URL_TAG, offset, offset)
                        .firstOrNull()?.let {

                        }
                }
            }
        }
    }
}