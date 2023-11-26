package tech.demura.hotelsearch.presentation.views.text_fields

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class MaskVisualTransformation(val mask: String, val maskChar: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskChar }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (maskIndex < mask.length) {
                if (mask[maskIndex] != maskChar) {
                    val nextDigitIndex = mask.indexOf(maskChar, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                    continue
                } else if (textIndex < trimmed.length) {

                    append(trimmed[textIndex++])
                } else {
                    append('*')
                }
                maskIndex++
            }
        }

        return TransformedText(
            annotatedString,
            MaskOffsetMapper(mask, maskChar, trimmed.toString(), annotatedString)
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MaskVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskChar != other.maskChar) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class MaskOffsetMapper(
    val mask: String,
    val numberChar: Char,
    val text: String,
    val annotatedString: AnnotatedString
) :
    OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        if (annotatedString.isEmpty()) return 0
        var noneDigitCount = 0
        var i = 0
        while (i <= offset + noneDigitCount && i < mask.length) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        if (text.length == 0) {
            return noneDigitCount
        }
        if (offset > text.length)
            return text.length + noneDigitCount
        else
            return offset + noneDigitCount

    }

    override fun transformedToOriginal(offset: Int): Int {
        val realOffset = offset - mask.take(offset).count { it != numberChar }
        return if (realOffset > text.length)
            text.length
        else
            realOffset
    }

}