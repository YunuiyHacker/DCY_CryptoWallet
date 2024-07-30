package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.ButtonDisabledGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary

@Composable
fun SeedIndicator(modifier: Modifier = Modifier, size: Int, currentSeed: Int) {
    Row(
        modifier = modifier.height(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(size) { index ->
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .clip(CircleShape)
                    .background(color = if (index <= currentSeed) Primary else ButtonDisabledGray)
            )
            if (currentSeed < size) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}