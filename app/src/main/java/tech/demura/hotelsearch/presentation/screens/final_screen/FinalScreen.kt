package tech.demura.hotelsearch.presentation.screens.final_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.presentation.screens.final_screen.components.FinalInfo
import tech.demura.hotelsearch.presentation.screens.final_screen.components.FinalScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinalScreen(
    onButtonClick: () -> Unit,
    onBackPressed: () -> Unit
) {
    BackHandler {
        onBackPressed()
    }

    Scaffold(
        topBar = {
            FinalScreenTopBar(
                onBackPressed = onBackPressed
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            // FINAL INFO
            FinalInfo()

            // BUTTON FINAL
            Button(
                onClick = { onButtonClick() },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0D72FF)
                )
            ) {
                Text(
                    text = "Супер!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            }

        }
    }
}