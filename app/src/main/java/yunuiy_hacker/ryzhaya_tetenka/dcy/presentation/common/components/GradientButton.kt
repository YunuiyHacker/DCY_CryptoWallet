package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.ButtonDisabledGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = if (enabled) Brush.horizontalGradient(
                    colors = Constants.GRADIENT_LIST_1
                ) else Brush.horizontalGradient(
                    colors = listOf(
                        ButtonDisabledGray,
                        ButtonDisabledGray
                    )
                ),
                shape = ButtonDefaults.shape
            )
            .height(ButtonDefaults.MinHeight),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
            disabledContainerColor = ButtonDisabledGray,
            disabledContentColor = DarkGray
        ), enabled = enabled
    ) {
        Text(
            text,
            style = TextStyle(
                fontFamily = archivo,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
            )
        )
    }
}