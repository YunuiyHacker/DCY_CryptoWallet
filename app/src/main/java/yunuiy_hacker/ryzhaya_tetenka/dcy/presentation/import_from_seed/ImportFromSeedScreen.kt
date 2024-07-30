package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed

import android.graphics.Typeface
import android.text.Html
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.text.util.Linkify
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.toSpannable
import androidx.navigation.NavController
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.GradientButton
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.components.OutlinedTextField
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.HintGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.LinkBlue
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.TermsGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.URL_TAG

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportFromSeedScreen(navController: NavController, viewModel: ImportFromSeedViewModel) {
    Scaffold(containerColor = DarkBackground, topBar = {
        TopAppBar(title = {
            Text(
                text = "Import From Seed",
                fontFamily = archivo,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp)
            )
        }, navigationIcon = {
            IconButton(onClick = { navController.navigate(Route.WalletSetupScreen.route) }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBackground))
    }, bottomBar = {
        GradientButton(
            text = "Import",
            onClick = { navController.navigate(Route.HomeScreen.route) },
            modifier = Modifier.padding(start = 24.dp, top = 8.dp, end = 24.dp, bottom = 42.dp),
            enabled = viewModel.state.isValid
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = viewModel.state.seedPhrase,
                    onValueChange = {
                        viewModel.onEvent(ImportFromSeedEvent.SeedChange(it))
                    },
                    placeholderText = "Seed Phrase",
                    trailingIconClick = { viewModel.onEvent(ImportFromSeedEvent.SeedVisibleChange) },
                    trailingIsChecked = viewModel.state.seedPhraseVisible
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_scan),
                        contentDescription = "",
                        tint = Primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.state.newPassword,
                onValueChange = {
                    viewModel.onEvent(ImportFromSeedEvent.NewPasswordChange(it))
                },
                placeholderText = "New Password",
                trailingIconClick = { viewModel.onEvent(ImportFromSeedEvent.NewPasswordVisibleChange) },
                trailingIsChecked = viewModel.state.newPasswordVisible,
                supportingText = "Must be at least 8 characters",
                singleLine = true
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.state.confirmPassword,
                onValueChange = {
                    viewModel.onEvent(ImportFromSeedEvent.ConfirmPasswordChange(it))
                },
                placeholderText = "Confirm Password",
                trailingIconClick = { viewModel.onEvent(ImportFromSeedEvent.ConfirmPasswordVisibleChange) },
                trailingIsChecked = viewModel.state.confirmPasswordVisible,
                singleLine = true,
                endTextField = true
            )
            Spacer(modifier = Modifier.height(26.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 4.dp),
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
                    onCheckedChange = { viewModel.onEvent(ImportFromSeedEvent.SignInWithFaceIdChange) },
                    colors = SwitchDefaults.colors(
                        uncheckedBorderColor = Color.Transparent,
                        checkedBorderColor = Color.Transparent,
                        checkedTrackColor = Primary,
                        checkedThumbColor = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(37.dp))

            val someText = Html.fromHtml(
                "By proceeding, you agree to these <a href=\"https://google.com\">Term and Conditions.</a>",
                Html.FROM_HTML_MODE_COMPACT
            )
            val linkColor = LinkBlue
            val annotatedString = someText.toAnnotateString(
                baseSpanStyle = SpanStyle(
                    color = HintGray,
                    fontFamily = archivo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                linkColor = linkColor
            )
            ClickableText(
                text = annotatedString,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(lineHeight = 24.sp)
            ) { offset ->
                annotatedString.getStringAnnotations(URL_TAG, offset, offset).firstOrNull()?.let {
                    navController.navigate(Route.TermsAndConditionsScreen.route)
                }
            }
        }
    }
}

fun Spanned.toAnnotateString(
    baseSpanStyle: SpanStyle?,
    linkColor: Color,
    useUnderline: Boolean = true,
    fontWeight: FontWeight = FontWeight.Normal
): AnnotatedString {
    return buildAnnotatedString {
        val spanned = this@toAnnotateString
        append(spanned.toString())
        baseSpanStyle?.let { addStyle(it, 0, length) }
        getSpans(0, spanned.length, Any::class.java).forEach { span ->
            val start = getSpanStart(span)
            val end = getSpanEnd(span)
            when (span) {
                is URLSpan -> {
                    addStyle(
                        SpanStyle(
                            textDecoration = if (useUnderline) TextDecoration.Underline else TextDecoration.None,
                            color = linkColor,
                            fontWeight = fontWeight
                        ), start, end
                    )
                    addStringAnnotation(URL_TAG, span.url, start, end)
                }
            }
        }
    }
}