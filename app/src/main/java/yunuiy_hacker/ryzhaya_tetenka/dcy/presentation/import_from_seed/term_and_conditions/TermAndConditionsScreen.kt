package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.import_from_seed.term_and_conditions

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkBackground
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.TERMS_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermAndConditionsScreen(navController: NavController) {
    Scaffold(containerColor = DarkBackground, topBar = {
        TopAppBar(title = {
            Text(
                text = "Terms and Conditions",
                fontFamily = archivo,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp)
            )
        }, navigationIcon = {
            IconButton(onClick = { navController.navigate(Route.ImportFromSeedScreen.route) }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBackground))
    }) {
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(TERMS_URL)
            }
        }, modifier = Modifier.padding(it))
    }
}