package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo

@Composable
fun Snackbar(
    modifier: Modifier = Modifier,
    title: String,
    containerColor: Color,
    @DrawableRes icon: Int,
    iconTint: Color
) {
    androidx.compose.material3.Snackbar(
        containerColor = containerColor,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.padding(start = 24.dp, end = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Transparent, shape = RoundedCornerShape(16.dp)
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                tint = iconTint
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                fontFamily = archivo,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}