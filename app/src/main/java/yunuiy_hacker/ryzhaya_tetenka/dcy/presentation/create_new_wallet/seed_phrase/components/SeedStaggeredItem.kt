package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.IndicatorGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.TermsGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo

@Composable
fun SeedStaggeredItem(title: String, modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    Row(
        modifier = modifier.height(32.dp)
            .background(color = IndicatorGray, shape = RoundedCornerShape(8.dp))
            .clickable { onClick(title) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = Color.White,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}