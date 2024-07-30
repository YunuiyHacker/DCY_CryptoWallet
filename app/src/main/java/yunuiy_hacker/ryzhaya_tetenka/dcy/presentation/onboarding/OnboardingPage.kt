package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.GRADIENT_LIST_1

@Composable
fun OnboardingPage(modifier: Modifier = Modifier, page: Page) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = page.img),
            contentDescription = "",
            modifier = Modifier
                .size(295.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))

        if (!page.reverse) {
            Text(
                text = page.firstTitle,
                color = Color.White,
                fontFamily = archivo,
                fontWeight = FontWeight.Normal,
                fontSize = 40.sp,
                style = MaterialTheme.typography.labelSmall,
                lineHeight = TextUnit(value = 56f, type = TextUnitType.Sp)
            )
        }
        Text(
            text = page.secondTitle,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = GRADIENT_LIST_1,
                    tileMode = TileMode.Mirror
                ),
                fontSize = 40.sp
            ),
            lineHeight = TextUnit(value = 56f, type = TextUnitType.Sp)
        )
        if (page.reverse) {
            Text(
                text = page.firstTitle,
                color = Color.White,
                fontFamily = archivo,
                fontWeight = FontWeight.Normal,
                fontSize = 40.sp,
                style = MaterialTheme.typography.labelSmall,
                lineHeight = TextUnit(value = 56f, type = TextUnitType.Sp)
            )
        }
    }
}
