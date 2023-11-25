package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.domain.entity.Tourist
import tech.demura.hotelsearch.extensions.toWordInt
import tech.demura.hotelsearch.presentation.views.text_fields.DateTextField
import tech.demura.hotelsearch.presentation.views.text_fields.SimpleTextField

@Composable
fun TouristCard(
    tourist: Tourist,
    isTouristChanged: (Tourist) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "${tourist.id.toWordInt()} турист",
                fontSize = 24.sp,
                fontWeight = FontWeight(500)
            )

            // COLLAPSE
            Button(
                onClick = {
                    isTouristChanged(
                        tourist.copy(
                            isCollapsed = !tourist.isCollapsed),
                    )
                },
                modifier = Modifier.size(32.dp),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x1A0D72FF),
                    contentColor = Color(0xFF0D72FF)
                )
            ) {
                if (tourist.isCollapsed) {
                    Icon(Icons.Filled.KeyboardArrowDown, contentDescription = null)
                } else {
                    Icon(Icons.Filled.KeyboardArrowUp, contentDescription = null)
                }
            }
        }
        if (!tourist.isCollapsed) {
            //
            SimpleTextField(
                text = tourist.name,
                labelText = "Имя",
                isDateChanged = {
                    isTouristChanged(
                        tourist.copy(
                            name = it,
                            isNameValid = it.isNotEmpty()
                        )
                    )
                },
                isValid = tourist.isNameValid
            )
            Spacer(modifier = Modifier.height(8.dp))

            // LAST NAME
            SimpleTextField(
                text = tourist.lastName,
                labelText = "Фамилия",
                isDateChanged = {
                    isTouristChanged(
                        tourist.copy(
                            lastName = it,
                            isLastNameValid = it.isNotEmpty()
                        )
                    )
                },
                isValid = tourist.isLastNameValid
            )
            Spacer(modifier = Modifier.height(8.dp))

            // DATE OF BIRTH
            DateTextField(
                date = tourist.dateOfBirth,
                labelText = "День рождения",
                isDateChanged = {
                    isTouristChanged(
                        tourist.copy(
                            dateOfBirth = it,
                            isDateOfBirthValid = dateValid(it)
                        )
                    )
                },
                isValid = tourist.isDateOfBirthValid
            )
            Spacer(modifier = Modifier.height(8.dp))

            // CITIZENSHIP
            SimpleTextField(
                text = tourist.citizenship,
                labelText = "Гражданство",
                isDateChanged = {
                    isTouristChanged(
                        tourist.copy(
                            citizenship = it,
                            isCitizenshipValid = it.isNotEmpty()
                        )
                    )
                },
                isValid = tourist.isCitizenshipValid
            )
            Spacer(modifier = Modifier.height(8.dp))


            // PASSPORT NUMBER
            SimpleTextField(
                text = tourist.internationalPassport,
                labelText = "Номер загранпаспорта",
                isDateChanged = {
                    isTouristChanged(
                        tourist.copy(
                            internationalPassport = it,
                            isInternationalPassportValid = it.isNotEmpty()
                        )
                    )
                },
                isValid = tourist.isInternationalPassportValid
            )
            Spacer(modifier = Modifier.height(8.dp))

            // PASSPORT VALID
            DateTextField(
                date = tourist.validityPeriodOfThePassport,
                labelText = "Срок действия загранпаспорта",
                isDateChanged = {
                    isTouristChanged(
                        tourist.copy(
                            validityPeriodOfThePassport = it,
                            isValidityPeriodOfThePassportValid = dateValid(it)
                        )
                    )
                },
                isValid = tourist.isValidityPeriodOfThePassportValid
            )
        }
    }
}

private fun dateValid(date: String): Boolean{
    val dateLength = 8
    val phoneRegex = "^(\\d{$dateLength})\$".toRegex()
    return date.matches(phoneRegex)
}

