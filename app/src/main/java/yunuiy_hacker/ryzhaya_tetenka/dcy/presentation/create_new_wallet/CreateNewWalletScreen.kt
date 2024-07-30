package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.GradientButton
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.components.ProcessIndicator
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password.CreatePasswordScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.create_password.CreatePasswordViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.secure_your_wallet.SecureYourWalletFirstScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.secure_your_wallet.SecureYourWalletSecondScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.ConfirmSeedPhraseEvent
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.ConfirmSeedPhraseScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.ConfirmSeedPhraseViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.ResultScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.ViewSeedPhraseScreen
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase.ViewSeedPhraseViewModel
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CreateNewWalletScreen(navController: NavController, viewModel: CreateNewWalletViewModel) {
    val pagerState = rememberPagerState(
        initialPage = viewModel.state.currentPage,
        pageCount = { viewModel.state.pages })
    viewModel.state.currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val bottomSheetState = rememberBottomSheetScaffoldState()

    Scaffold(topBar = {
        TopAppBar(title = {
            ProcessIndicator(
                processSize = viewModel.state.processSize,
                currentProcess = viewModel.state.currentProcess
            )
        }, navigationIcon = {
            IconButton(onClick = {
                when (viewModel.state.currentPage) {
                    0 -> navController.navigate(Route.WalletSetupScreen.route)
                    else -> {
                        viewModel.state.currentPage--
                        scope.launch {
                            pagerState.animateScrollToPage(viewModel.state.currentPage)
                        }
                        viewModel.onEvent(CreateNewWalletEvent.ToPage(viewModel.state.currentPage))
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBackground)
        )
    }, bottomBar = {
        GradientButton(
            text = when (viewModel.state.currentPage) {
                0 -> "Create Password"
                1 -> "Start"
                2 -> "Start"
                3 -> "Next"
                4 -> "Next"
                5 -> "Next"
                else -> ""
            },
            onClick = {
                if (viewModel.state.currentPage == 4 && viewModel.state.seedPage < 2) {
                    viewModel.state.seedPage++
                } else if (viewModel.state.currentPage == 4 && viewModel.state.seedPage == 2) {
                    if (viewModel.state.thirdPageValid) {
                        viewModel.onEvent(CreateNewWalletEvent.ToPage(viewModel.state.currentPage + 1))
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        viewModel.onEvent(
                            CreateNewWalletEvent.ToPage(3)
                        )
                        scope.launch {
                            pagerState.animateScrollToPage(3)
                            viewModel.state.seedPage = 0
                        }
                    }
                } else if (viewModel.state.currentPage == 5) {
                    navController.navigate(Route.HomeScreen.route)
                } else {
                    viewModel.onEvent(CreateNewWalletEvent.ToPage(viewModel.state.currentPage + 1))
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            modifier = Modifier.padding(start = 24.dp, top = 8.dp, end = 24.dp, bottom = 42.dp),
            enabled = when (viewModel.state.currentPage) {
                0 -> viewModel.state.firstPageValid
                3 -> viewModel.state.secondPageValid
                4 -> if (viewModel.state.seedPage < 2) viewModel.state.thirdPageValid else true
                else -> {
                    true
                }
            }
        )
    }, snackbarHost = {
        SnackbarHost(snackbarHostState) { data ->
            yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.Snackbar(
                title = "You have not passed the verification, please try again",
                containerColor = Color(0x20FF0000),
                icon = R.drawable.ic_error,
                iconTint = Color.Red, modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }, containerColor = DarkBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = false
            ) {
                when (it) {
                    0 -> {
                        val createPasswordViewModel: CreatePasswordViewModel = hiltViewModel()
                        CreatePasswordScreen(
                            navController = navController, viewModel = createPasswordViewModel
                        )
                        viewModel.state.firstPageValid = createPasswordViewModel.state.isValid
                    }
                    1 -> {
                        SecureYourWalletFirstScreen(navController = navController)
                    }
                    2 -> SecureYourWalletSecondScreen()
                    3 -> {
                        val viewSeedPhraseViewModel: ViewSeedPhraseViewModel = hiltViewModel()
                        ViewSeedPhraseScreen(viewModel = viewSeedPhraseViewModel)
                        viewModel.state.secondPageValid = viewSeedPhraseViewModel.seedVisible
                        viewModel.state.seedPhrase = viewSeedPhraseViewModel.seedPhrase
                        if (!viewModel.state.thirdPagePassed) {
                            LaunchedEffect(snackbarHostState) {
                                snackbarHostState.showSnackbar(message = "")
                            }
                        }
                    }
                    4 -> {
                        val confirmSeedPhraseViewModel: ConfirmSeedPhraseViewModel = hiltViewModel()
                        ConfirmSeedPhraseScreen(viewModel = confirmSeedPhraseViewModel)
                        confirmSeedPhraseViewModel.state.seedPhrase = viewModel.state.seedPhrase
                        confirmSeedPhraseViewModel.state.currentSeed = viewModel.state.seedPage
                        viewModel.state.thirdPageValid = confirmSeedPhraseViewModel.state.valid
                        viewModel.state.thirdPagePassed =
                            confirmSeedPhraseViewModel.state.seedWordsPassed
                        confirmSeedPhraseViewModel.onEvent(ConfirmSeedPhraseEvent.GetWords)
                    }
                    5 -> {
                        ResultScreen()
                    }
                }
                viewModel.onEvent(CreateNewWalletEvent.ToPage(it))
            }
        }
    }
}