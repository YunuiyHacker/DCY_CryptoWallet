package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.wallet_setup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.common.components.GradientButton
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.DarkGray
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants.BUTTON_CORNER_RADIUS

@Composable
fun WalletSetupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(165.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            painter = painterResource(id = R.drawable.wallet_img),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(71.dp))
        Text(
            text = "Wallet Setup",
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            color = Color.White,
            lineHeight = TextUnit(value = 56f, type = TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Button(
            onClick = { navController.navigate(Route.ImportFromSeedScreen.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkGray,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(BUTTON_CORNER_RADIUS)
        ) {
            Text(
                text = "Import Using Seed Phrase", fontFamily = archivo,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = TextUnit(value = 24f, type = TextUnitType.Sp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        GradientButton(
            text = "Create a New Wallet",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            onClick = { navController.navigate(Route.CreateNewWalletScreen.route) })
    }
}