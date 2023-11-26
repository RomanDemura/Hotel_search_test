package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.text_fields.EmailTextField
import tech.demura.hotelsearch.presentation.views.text_fields.PhoneTextField
import tech.demura.hotelsearch.presentation.views.texts.HeaderText
import tech.demura.hotelsearch.presentation.views.texts.SmallDescriptionText

@Composable
fun BuyerInfoCard(
    isPhoneValid: (Boolean) -> Unit,
    isEmailValid: (Boolean) -> Unit
) {
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    ThemedCard()
    {

        //BUYER INFO HEADER
        Spacer(modifier = Modifier.height(16.dp))
        HeaderText(text = "Информация о покупателе")
        Spacer(modifier = Modifier.height(16.dp))

        // PHONE FIELD
        PhoneTextField(
            phone = phoneNumber,
            onPhoneChanged = { phoneNumber = it },
            isValid = isPhoneValid
        )
        Spacer(modifier = Modifier.height(8.dp))

        // EMAIL FIELD
        EmailTextField(
            email = email,
            onEmailChange = { email = it },
            isValid = isEmailValid
        )
        Spacer(modifier = Modifier.height(8.dp))

        SmallDescriptionText(
            text = "Эти данные никому не передаются. После оплаты мы вышлем чек на указанный вами номер и почту."
        )

    }
}
