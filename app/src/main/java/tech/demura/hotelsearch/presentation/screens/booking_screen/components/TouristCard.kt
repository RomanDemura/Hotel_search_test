package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.Tourist
import tech.demura.hotelsearch.extensions.toWordInt
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.buttons.SmallButtonWithIcon
import tech.demura.hotelsearch.presentation.views.rows.ThemedRow
import tech.demura.hotelsearch.presentation.views.text_fields.DateTextField
import tech.demura.hotelsearch.presentation.views.text_fields.SimpleTextField
import tech.demura.hotelsearch.presentation.views.texts.HeaderText

@Composable
fun TouristCard(
    tourist: Tourist,
    isTouristChanged: (Tourist) -> Unit
) {
    ThemedCard {
        // TOURIST HEADER
        ThemedRow {

            // HEADER TEXT
            HeaderText(
                text = "${tourist.id.toWordInt()} турист",
                modifier = Modifier.weight(1f)
            )

            // COLLAPSE BUTTON
            SmallButtonWithIcon(
                imageVector =
                if (tourist.isCollapsed)
                    Icons.Filled.KeyboardArrowDown
                else
                    Icons.Filled.KeyboardArrowUp,
                onClick = {
                    isTouristChanged(
                        tourist.copy(
                            isCollapsed = !tourist.isCollapsed
                        ),
                    )
                }
            )
        }

        // TOURIST CARD BODY
        if (!tourist.isCollapsed) {

            // TOURIST NAME FIELD
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

            // TOURIST LAST NAME FIELD
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

            // TOURIST DATE OF BIRTH FIELD
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

            // TOURIST CITIZENSHIP FIELD
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


            // TOURIST PASSPORT NUMBER FIELD
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

            // TOURIST PASSPORT VALID FIELD
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

// DATE VALIDATION
private fun dateValid(date: String): Boolean {
    val dateLength = 8
    val phoneRegex = "^(\\d{$dateLength})\$".toRegex()
    return date.matches(phoneRegex)
}

