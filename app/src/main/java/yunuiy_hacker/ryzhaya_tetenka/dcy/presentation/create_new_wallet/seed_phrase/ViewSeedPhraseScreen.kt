package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.components.SeedItem
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.IndicatorGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.TermsGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants

@Composable
fun ViewSeedPhraseScreen(viewModel: ViewSeedPhraseViewModel) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Write Down Your Seed Phrase",
            style = TextStyle(brush = Brush.horizontalGradient(Constants.GRADIENT_LIST_2)),
            fontFamily = archivo,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(value = 28f, type = TextUnitType.Sp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "This is your seed phrase. Write it down on a paper and keep it in a safe place. You'll be asked to re-enter this phrase (in order) on the next step.",
            color = TermsGray,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.height(64.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(width = 1.dp, color = IndicatorGray),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Column(
                modifier = if (!viewModel.seedVisible) Modifier
                    .fillMaxWidth()
                    .background(color = Color(0x99222531), shape = RoundedCornerShape(8.dp))
                    .blur(24.dp, 24.dp)
                    .padding(24.dp) else
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent, shape = RoundedCornerShape(8.dp))
                        .padding(24.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(12) { index ->
                        SeedItem(
                            title = "${index + 1}. ${viewModel.seedPhrase.get(index)}",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            if (!viewModel.seedVisible) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tap to reveal your seed phrase",
                        fontFamily = archivo,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Make sure no one is watching your screen.",
                        fontFamily = archivo,
                        color = TermsGray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = TextUnit(value = 18f, type = TextUnitType.Sp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    ElevatedButton(onClick = { viewModel.seedVisible = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_password_visible),
                            contentDescription = "",
                            tint = Primary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "View",
                            fontFamily = archivo,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
                        )
                    }
                }
            }
        }
    }
}