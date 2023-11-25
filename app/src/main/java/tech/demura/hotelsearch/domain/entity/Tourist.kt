package tech.demura.hotelsearch.domain.entity

data class Tourist(
    val id: Int = 0,
    var name: String = "",
    var lastName: String = "",
    var dateOfBirth: String = "",
    var citizenship: String = "",
    var internationalPassport: String = "",
    var validityPeriodOfThePassport: String = "",
    var isCollapsed: Boolean = true,
    var isNameValid: Boolean = false,
    var isLastNameValid: Boolean = false,
    var isDateOfBirthValid: Boolean = false,
    var isCitizenshipValid: Boolean = false,
    var isInternationalPassportValid: Boolean = false,
    var isValidityPeriodOfThePassportValid: Boolean = false,
)
