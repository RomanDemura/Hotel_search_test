package tech.demura.hotelsearch.presentation.views.text_fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(
    email: String,
    onEmailChange: (String) -> Unit,
    isValid: (Boolean) -> Unit
) {

    var isValidState by rememberSaveable {
        mutableStateOf(true)
    }

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = email,
        onValueChange = {
            onEmailChange(it)
            isValidState = isValidEmail(it)
            isValid(isValidState)
        },
        label = { Text("Почта") },
        placeholder = {
            Text(text = "Examle@mail.ru")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            containerColor = if (isValidState) {
                Color(0xFFF6F6F9)
            } else {
                Color(0x1AEB5757)
            },
        )
    )
}

private fun isValidEmail(email: String): Boolean {
    val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    return email.matches(emailRegex)
}
