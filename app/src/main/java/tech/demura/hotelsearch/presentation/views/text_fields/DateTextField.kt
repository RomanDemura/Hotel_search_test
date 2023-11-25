package tech.demura.hotelsearch.presentation.views.text_fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTextField(
    date: String,
    labelText: String,
    mask: String = "**.**.****",
    maskChar: Char = '*',
    isDateChanged: (String) -> Unit,
    isValid: Boolean = true
){
    fun isValidDate(date: String): Boolean {
        val dateLength = mask.count{ it == maskChar }
        val dateRegex = "^(\\d{$dateLength})\$".toRegex()
        return date.matches(dateRegex)
    }


    var isChanged by remember {
        mutableStateOf(false)
    }

    val valid = if (isChanged){
        isValid
    } else {
        true
    }

    TextField(
        label = {
            Text(text = labelText)
        },
        value = date,
        onValueChange = {
            val trimmed = it.take(mask.count{ char -> char == maskChar })
            isDateChanged(trimmed)
            isChanged = true

        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = MaskVisualTransformation(mask, maskChar),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = if (valid) {
                Color(0xFFF6F6F9)
            } else {
                Color(0x1AEB5757)
            },
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
}

