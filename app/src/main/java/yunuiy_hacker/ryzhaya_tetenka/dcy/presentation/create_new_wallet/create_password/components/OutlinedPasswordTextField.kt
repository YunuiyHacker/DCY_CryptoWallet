package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
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
fun OutlinedPasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    trailingIconClick: () -> Unit,
    trailingIsChecked: Boolean,
    singleLine: Boolean = false,
    endTextField: Boolean = false,
    passwordStrength: Int = 0
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
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = HintGray,
                            fontFamily = archivo,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    ) {
                        append("Password strength: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = when
                                            (passwordStrength) {
                                0 -> Color.Red
                                1 -> Color.Yellow
                                2 -> Color(0xFF76E268)
                                else -> {
                                    Color.Red
                                }
                            },
                            fontFamily = archivo,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    ) {
                        when (passwordStrength) {
                            0 -> append("Low")
                            1 -> append("Good")
                            2 -> append("High")
                        }

                    }
                },

                lineHeight = TextUnit(value = 16f, type = TextUnitType.Sp),
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
        keyboardOptions = KeyboardOptions(imeAction = if (endTextField) ImeAction.Done else ImeAction.Next),
    )
}