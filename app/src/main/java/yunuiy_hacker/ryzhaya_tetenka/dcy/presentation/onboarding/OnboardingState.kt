package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding

import yunuiy_hacker.ryzhaya_tetenka.dcy.R

data class OnboardingState(
    val pages: List<Page> = listOf(
        Page(
            R.drawable.onboarding_img_1, "Property", "Diversity", false
        ), Page(
            R.drawable.onboarding_img_2, "Safe", "Security", false
        ), Page(
            R.drawable.onboarding_img_3, "Transaction", "Convenient", true
        )
    )
)