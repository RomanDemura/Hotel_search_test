package tech.demura.hotelsearch.presentation.views.rows

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TagsRow(tags: List<String>) {
    FlowRow {
        tags.forEach {
            AssistChip(
                onClick = { },
                label = {
                    Text(
                        text = it,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500)
                    )
                },
                shape = RoundedCornerShape(4.dp),
                border = null,
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color(0xFFFBFBFC),
                    labelColor = Color(0xFF828796)
                )
            )
        }
    }
}
