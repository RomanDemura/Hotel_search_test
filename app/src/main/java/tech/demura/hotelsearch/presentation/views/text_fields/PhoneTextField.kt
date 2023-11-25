package tech.demura.hotelsearch.presentation.views.text_fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneTextField(
    phone: String,
    mask: String = "+7 (***) ***-**-**",
    maskChar: Char = '*',
    onPhoneChanged: (String) -> Unit,
    isValid: (Boolean) -> Unit
) {
    var isValidState by rememberSaveable {
        mutableStateOf(true)
    }

    fun isValidPhone(phone: String): Boolean {
        val phoneRegex = "^9(\\d{9})\$".toRegex()
        return phone.matches(phoneRegex)
    }

    TextField(
        value = phone,
        onValueChange = { it ->
            val trimmed = it.take(mask.count { it == maskChar })
            onPhoneChanged(trimmed)
            isValidState = isValidPhone(trimmed)
            isValid(isValidState)
        },
        label = {
            Text(
                text = "Номер телефона"
            )
        },
        placeholder = {
            Text(text = "+7 (***) ***-**-**")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = MaskVisualTransformation(mask, maskChar),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = if (isValidState) {
                Color(0xFFF6F6F9)
            } else {
                Color(0x1AEB5757)
            },
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
}

