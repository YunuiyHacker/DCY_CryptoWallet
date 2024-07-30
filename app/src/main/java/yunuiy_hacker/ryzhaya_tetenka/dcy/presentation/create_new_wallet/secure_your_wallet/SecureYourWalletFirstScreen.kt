package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.secure_your_wallet

import android.text.Html
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.GradientButton
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.WhatIsSeedBottomSheet
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.toAnnotateString
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.HintGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.LinkBlue
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.TermsGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecureYourWalletFirstScreen(navController: NavController) {
    val bottomSheetState = rememberModalBottomSheetState(confirmValueChange = { true })
    var firstBottomSheetIsVisible by remember {
        mutableStateOf(false)
    }
    var secondBottomSheetIsVisible by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_img_2),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, top = 24.dp, end = 40.dp, bottom = 24.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Secure Your Wallet",
                    fontFamily = archivo,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White,
                    lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                val someText = Html.fromHtml(
                    "Don't risk losing your funds. protect your wallet by saving your <a href=\"https://google.com\">Seed phrase</a> in a place you trust.",
                    Html.FROM_HTML_MODE_COMPACT
                )
                val annotatedString = someText.toAnnotateString(
                    baseSpanStyle = SpanStyle(
                        color = HintGray,
                        fontFamily = archivo,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    ), linkColor = LinkBlue, useUnderline = false, fontWeight = FontWeight.SemiBold
                )
                ClickableText(text = annotatedString, style = TextStyle(
                    lineHeight = TextUnit(
                        value = 24f, type = TextUnitType.Sp
                    )
                ), onClick = {
                    secondBottomSheetIsVisible = true
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "It's the only way to recover your wallet if you get locked out of the app or get a new device.",
                    fontFamily = archivo,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = TermsGray,
                    lineHeight = TextUnit(
                        value = 24f, type = TextUnitType.Sp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(47.dp))
        TextButton(onClick = {
            firstBottomSheetIsVisible = true
        }) {
            Text(
                text = "Remind Me Later",
                fontFamily = archivo,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = LinkBlue,
                lineHeight = TextUnit(
                    value = 24f, type = TextUnitType.Sp
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = firstBottomSheetIsVisible, enter = fadeIn(),
            exit = fadeOut(animationSpec = tween(200)) + scaleOut()
        ) {
            var checkboxState by remember {
                mutableStateOf(true)
            }
            ModalBottomSheet(
                onDismissRequest = { firstBottomSheetIsVisible = false },
                sheetState = bottomSheetState,
                shape = RectangleShape,
                containerColor = DarkBackground
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Skip Account Security?",
                        fontFamily = archivo,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    ) {
                        Spacer(modifier = Modifier.height(40.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Checkbox(
                                checked = checkboxState,
                                onCheckedChange = { checkboxState = !checkboxState },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Primary, checkmarkColor = Color.White
                                )
                            )
                            Text(
                                text = "I dunderstand that if i lose mt seed phrase i will not be able to access my wallet",
                                fontFamily = archivo,
                                color = Color.White,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                                modifier = Modifier.padding(top = 10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(51.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(
                                onClick = { firstBottomSheetIsVisible = false },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Secure",
                                    fontFamily = archivo,
                                    color = LinkBlue,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
                                )
                            }
                            Spacer(modifier = Modifier.width(15.dp))
                            GradientButton(
                                text = "Skip", onClick = {
                                    firstBottomSheetIsVisible = false
                                    navController.navigate(Route.HomeScreen.route)
                                }, modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(42.dp))
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = secondBottomSheetIsVisible
        ) {
            WhatIsSeedBottomSheet(onDismissRequest = { secondBottomSheetIsVisible = false })
        }
    }
}