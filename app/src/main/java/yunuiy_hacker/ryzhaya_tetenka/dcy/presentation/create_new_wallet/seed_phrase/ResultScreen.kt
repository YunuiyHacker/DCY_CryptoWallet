package yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.create_new_wallet.seed_phrase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yunuiy_hacker.ryzhaya_tetenka.dcy.R
import yunuiy_hacker.ryzhaya_tetenka.dcy.presentation.ui.theme.archivo
import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.Constants

@Composable
fun ResultScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.success_img),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 24.dp, end = 20.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Success!",
            style = TextStyle(brush = Brush.horizontalGradient(Constants.GRADIENT_LIST_2)),
            lineHeight = 56.sp,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "You've successfully protected your wallet. Remember to keep your seed phrase safe, it's your responsibility!",
            color = Color.White,
            lineHeight = 24.sp,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "DefiSquid cannot recover your wallet should you lose it. You can find your seedphrase in Setings > Security & Privacy",
            color = Color.White,
            lineHeight = 24.sp,
            fontFamily = archivo,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}