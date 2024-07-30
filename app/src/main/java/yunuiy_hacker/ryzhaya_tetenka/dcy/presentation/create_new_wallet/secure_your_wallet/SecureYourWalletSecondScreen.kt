package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.secure_your_wallet

import android.text.Html
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.GradientButton
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.WhatIsSeedBottomSheet
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.toAnnotateString
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Green
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.HintGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.LinkBlue
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecureYourWalletSecondScreen() {
    var firstBottomSheetIsVisible by remember {
        mutableStateOf(false)
    }
    var secondBottomSheetIsVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Secure Your Wallet",
                style = TextStyle(brush = Brush.horizontalGradient(Constants.GRADIENT_LIST_2)),
                fontFamily = archivo,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                lineHeight = TextUnit(value = 28f, type = TextUnitType.Sp),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 50.dp)
            )
            IconButton(onClick = { firstBottomSheetIsVisible = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        val someText =
            Html.fromHtml(
                "Secure your wallet's \"<a href=\"https://google.com\">Seed Phrase</a>\"",
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
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Manual",
            fontFamily = archivo,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Write down your seed phrase on a piece of paper and store in a safe place.",
            fontFamily = archivo,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Security lever: Very strong",
                fontFamily = archivo,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.height(24.dp), verticalAlignment = Alignment.CenterVertically) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .width(52.dp)
                            .clip(CircleShape)
                            .background(color = Green)
                    )
                    if (it < 3) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Risks are: \n" +
                    "• You lose it\n" +
                    "• You forget where you put it\n" +
                    "• Someone else finds it",
            fontFamily = archivo,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Other options: Doesn't have to be paper!",
            fontFamily = archivo,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tips:\n" +
                    "• Store in bank vault\n" +
                    "• Store in a safe\n" +
                    "• Store in multiple secret places",
            fontFamily = archivo,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
        )

        AnimatedVisibility(visible = firstBottomSheetIsVisible) {
            val state = rememberModalBottomSheetState()
            ModalBottomSheet(
                onDismissRequest = {
                    firstBottomSheetIsVisible = false
                },
                sheetState = state,
                shape = RectangleShape,
                containerColor = DarkBackground
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Protect Your Wallet",
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
                        Text(
                            text = "Dont’t risk losing your funds. Protect your wallet by saving your seed phrase in a place you trust.",
                            fontFamily = archivo,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "It’s the only way to recover your wallet if you get locked out of the app or get a new device.",
                            fontFamily = archivo,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(48.dp))
                        GradientButton(
                            text = "I Got it",
                            onClick = { firstBottomSheetIsVisible = false },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Spacer(modifier = Modifier.height(42.dp))
            }
        }
        AnimatedVisibility(
            visible = secondBottomSheetIsVisible
        ) {
            WhatIsSeedBottomSheet(onDismissRequest = { secondBottomSheetIsVisible = false })
        }
    }
}