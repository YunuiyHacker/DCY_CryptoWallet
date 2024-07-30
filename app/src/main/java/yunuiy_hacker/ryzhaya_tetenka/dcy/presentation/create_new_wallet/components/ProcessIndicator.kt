package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.ProcessIndicatorGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.INDICATOR_SIZE

@Composable
fun ProcessIndicator(modifier: Modifier = Modifier, processSize: Int, currentProcess: Int) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 50.dp),
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(processSize) { index ->
            Box(
                modifier = Modifier
                    .background(
                        color = if (currentProcess >= index) Primary else ProcessIndicatorGray,
                        shape = RoundedCornerShape(50)
                    )
                    .size(INDICATOR_SIZE)
            )
            if (index < processSize - 1) {
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .width(90.dp)
                        .background(color = if (currentProcess > index) Primary else ProcessIndicatorGray)
                )
            }
        }
    }
}