package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding

import androidx.annotation.DrawableRes

data class Page(
    @DrawableRes val img: Int,
    val firstTitle: String,
    val secondTitle: String,
    val reverse: Boolean
)
