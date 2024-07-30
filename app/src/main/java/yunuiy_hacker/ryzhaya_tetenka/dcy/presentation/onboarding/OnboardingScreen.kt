package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import kotlinx.coroutines.launch
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.components.PageIndicator
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.BUTTON_CORNER_RADIUS
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.INDICATOR_HORIZONTAL_PADDING
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.INDICATOR_SIZE

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    pages: List<Page>, event: (OnboardingEvent) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(state = pagerState) { index ->
                OnboardingPage(
                    page = pages[index]
                )
            }
            Spacer(modifier = Modifier.height(72.dp))
        }
        PageIndicator(
            modifier = Modifier
                .width((pages.size * INDICATOR_SIZE) + ((pages.size - 1) * INDICATOR_HORIZONTAL_PADDING))
                .padding(bottom = 16.dp),
            pagesSize = pages.size,
            selectedPage = pagerState.currentPage
        )
        Button(
            onClick = {
                scope.launch {
                    if (pagerState.currentPage == pages.size - 1) event(OnboardingEvent.OnClick)
                    else pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 24.dp, end = 24.dp, bottom = 42.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkGray, contentColor = Color.White
            ),
            shape = RoundedCornerShape(BUTTON_CORNER_RADIUS)
        ) {
            Text(
                text = "Get started",
                fontFamily = archivo,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
            )
        }
    }

}