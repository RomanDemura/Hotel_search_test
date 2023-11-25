package tech.demura.hotelsearch.extensions

import android.net.Uri


fun String.encode(): String {
    return Uri.encode(this)
}

fun String.removeQuotes(): String{
    return this.trim('"')
}