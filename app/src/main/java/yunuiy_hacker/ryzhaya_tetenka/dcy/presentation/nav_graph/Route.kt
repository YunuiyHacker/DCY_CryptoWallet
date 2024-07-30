package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph

sealed class Route(val route: String) {
    object OnboardingScreen : Route("onboardingScreen")
    object WalletSetupScreen : Route("walletSetupScreen")
    object ImportFromSeedScreen : Route("importFromSeedScreen")
    object TermsAndConditionsScreen : Route("termsAndConditionsScreen")
    object CreateNewWalletScreen : Route("createNewWalletScreen")
    object HomeScreen : Route("homeScreen")

}
