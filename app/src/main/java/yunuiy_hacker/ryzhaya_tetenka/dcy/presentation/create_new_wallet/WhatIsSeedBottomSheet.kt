package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.GradientButton
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.LinkBlue
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatIsSeedBottomSheet(
    modifier: Modifier = Modifier, onDismissRequest: () -> Unit
) {
    val state = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
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
                text = "What is a 'Seed phrase'",
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
                    text = "A seed phrase is a set of twelve words that contains all the information about your wallet, including your funds. It's like a secret code used to access your entire wallet.\n" + "\n" + "You must keep your seed phrase secret and safe. If someone gets your seed phrase, they'll gain control over your accounts.\n" + "\n" + "Save it in a place where only you can access it. If you lose it, not even MetaMask can help you recover it.",
                    fontFamily = archivo,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(72.dp))
                GradientButton(
                    text = "I Got it",
                    onClick = { onDismissRequest() },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.height(42.dp))
    }
}