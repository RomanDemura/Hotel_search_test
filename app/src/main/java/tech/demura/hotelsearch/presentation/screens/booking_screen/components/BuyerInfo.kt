package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import android.service.autofill.DateTransformation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.presentation.views.PairRow
import tech.demura.hotelsearch.presentation.views.text_fields.DateTextField
import tech.demura.hotelsearch.presentation.views.text_fields.EmailTextField
import tech.demura.hotelsearch.presentation.views.text_fields.PhoneTextField

@Composable
fun BuyerInfo(
    isPhoneValid: (Boolean) -> Unit,
    isEmailValid: (Boolean) -> Unit
) { // TODO ( Change Name )
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

     Card(
         colors = CardDefaults.cardColors(
             containerColor = Color.White
         )
     ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Информация о покупателе",
            fontSize = 24.sp,
            fontWeight = FontWeight(500)
        )
        Spacer(modifier = Modifier.height(16.dp))
        PhoneTextField(
            phone = phoneNumber,
            mask = "+7 (***) ***-**-**",
            maskChar = '*',
            onPhoneChanged = { phoneNumber = it },
            isValid = isPhoneValid
        )
        Spacer(modifier = Modifier.height(8.dp))
        EmailTextField(
            email = email,
            onEmailChange = { email = it },
            isValid = isEmailValid
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Эти данные никому не передаются. После оплаты мы вышлем чек на указанный вами номер и почту.",
            fontSize = 14.sp,
            color = Color(0xFF828796)
        )

    }
}
