package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.INDICATOR_SIZE

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pagesSize: Int,
    selectedPage: Int,
    selectedColor: Color = Primary,
    unselectedColor: Color = DarkGray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pagesSize) { page ->
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(INDICATOR_SIZE)
                    .background(color = if (selectedPage == page) selectedColor else unselectedColor)
            )
        }
    }
}