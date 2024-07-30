package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.components.SeedIndicator
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.components.SeedItem
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.components.SeedStaggeredItem
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.HintGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.IndicatorGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants

@Composable
fun ConfirmSeedPhraseScreen(viewModel: ConfirmSeedPhraseViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Confirm Seed Phrase",
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
            text = "Select each word in the order it was presented to you",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = when (viewModel.state.currentSeed) {
                0 -> "3. ${viewModel.state.thirdWord}"
                1 -> "7. ${viewModel.state.seventhWord}"
                2 -> "12. ${viewModel.state.twelfthWord}"
                else -> {
                    "3. ${viewModel.state.thirdWord}"
                }
            },
            style = when (viewModel.state.currentSeed) {
                0 -> {
                    if (viewModel.state.thirdWord.isEmpty()) TextStyle(HintGray) else TextStyle(
                        Brush.horizontalGradient(Constants.GRADIENT_LIST_2)
                    )
                }

                1 -> {
                    if (viewModel.state.seventhWord.isEmpty()) TextStyle(HintGray) else TextStyle(
                        Brush.horizontalGradient(Constants.GRADIENT_LIST_2)
                    )
                }

                2 -> {
                    if (viewModel.state.twelfthWord.isEmpty()) TextStyle(HintGray) else TextStyle(
                        Brush.horizontalGradient(Constants.GRADIENT_LIST_2)
                    )
                }

                else -> {
                    if (viewModel.state.thirdWord.isEmpty()) TextStyle(HintGray) else TextStyle(
                        Brush.horizontalGradient(Constants.GRADIENT_LIST_2)
                    )
                }
            },
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            lineHeight = 56.sp
        )
        Spacer(modifier = Modifier.height(102.dp))
        SeedIndicator(
            modifier = Modifier.fillMaxWidth(),
            size = viewModel.state.seedsSize,
            currentSeed = viewModel.state.currentSeed
        )
        Spacer(modifier = Modifier.height(27.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(1.dp, color = IndicatorGray), RoundedCornerShape(8.dp)
                )
        ) {
            LazyHorizontalStaggeredGrid(
                rows = StaggeredGridCells.Fixed(2),
                modifier = Modifier
                    .height(124.dp)
                    .padding(24.dp)
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalItemSpacing = 16.dp,
            ) {
                viewModel.onEvent(ConfirmSeedPhraseEvent.GetWords)
                items(viewModel.state.seedWords) {
                    SeedStaggeredItem(modifier = Modifier.wrapContentSize(), title = it, onClick = {
                        when (viewModel.state.currentSeed) {
                            0 -> viewModel.onEvent(ConfirmSeedPhraseEvent.ClickThirdPhrase(it))
                            1 -> viewModel.onEvent(ConfirmSeedPhraseEvent.ClickSeventhPhrase(it))
                            2 -> viewModel.onEvent(ConfirmSeedPhraseEvent.ClickTwelfthPhrase(it))
                        }
                    })
                }
            }
        }
    }
}