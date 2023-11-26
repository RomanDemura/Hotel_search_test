package tech.demura.hotelsearch.extensions

fun Int.toPriceString(): String{
    var result = "₽"
    var prefix = ""
    var num = this
    if (num == 0) return "0 $result"
    if (num < 0){
        prefix = "-"
        num *= -1
    }
    while (num > 0){
        result = (num % 1000).toString() + ' ' + result
        num /= 1000
    }
    return prefix + result
}

fun Int.toWordInt(): String{
    return when (this){
        1 -> { "Первый" }
        2 -> { "Второй" }
        3 -> { "Третий" }
        4 -> { "Четвёртый" }
        5 -> { "Пятый" }
        6 -> { "Шестой" }
        7 -> { "Седьмой" }
        8 -> { "Восьмой" }
        9 -> { "Девятый" }
        10 -> { "Десятый" }
        else -> { "${this}-ый" }
    }
}