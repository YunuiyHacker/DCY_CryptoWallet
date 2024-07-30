package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.HintGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.IndicatorGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.Primary
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    trailingIconClick: () -> Unit,
    trailingIsChecked: Boolean,
    supportingText: String = "",
    singleLine: Boolean = false,
    endTextField: Boolean = false,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier,
        label = {
            Text(
                text = placeholderText,
                fontFamily = archivo,
                fontWeight = FontWeight.SemiBold,
                color = HintGray,
                fontSize = 14.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { trailingIconClick() }, modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    painter = if (trailingIsChecked) painterResource(id = R.drawable.ic_password_visible) else painterResource(
                        id = R.drawable.ic_password_invisible
                    ), contentDescription = ""
                )
            }
        },
        visualTransformation = if (trailingIsChecked) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = {
            Text(
                text = supportingText,
                color = HintGray,
                fontFamily = archivo,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = TextUnit(value = 18f, type = TextUnitType.Sp),
            )
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedIndicatorColor = IndicatorGray,
            focusedIndicatorColor = Primary,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent
        ),
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions(imeAction = if (endTextField) ImeAction.Done else ImeAction.Next)
    )

}