package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.CreateNewWalletScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.CreateNewWalletViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.home.HomeScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.ImportFromSeedScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.ImportFromSeedViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.term_and_conditions.TermAndConditionsScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.OnboardingScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.onboarding.OnboardingViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.wallet_setup.WalletSetupScreen

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    Surface(color = DarkBackground) {
        NavHost(navController = navController, startDestination = startDestination) {
            composable(route = Route.OnboardingScreen.route) {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnboardingScreen(pages = viewModel.state.pages, event = viewModel::onEvent)
            }
            composable(route = Route.WalletSetupScreen.route) {
                WalletSetupScreen(navController = navController)
            }
            composable(route = Route.ImportFromSeedScreen.route) {
                val viewModel: ImportFromSeedViewModel = hiltViewModel()
                ImportFromSeedScreen(navController = navController, viewModel = viewModel)
            }
            composable(route = Route.TermsAndConditionsScreen.route) {
                TermAndConditionsScreen(navController = navController)
            }
            composable(route = Route.CreateNewWalletScreen.route) {
                val viewModel: CreateNewWalletViewModel = hiltViewModel()
                CreateNewWalletScreen(navController = navController, viewModel = viewModel)
            }
            composable(route = Route.HomeScreen.route) {
                HomeScreen(navController = navController)
            }
        }
    }
}