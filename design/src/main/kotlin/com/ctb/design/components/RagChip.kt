package com.ctb.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctb.design.theme.RagTheme
import com.ctb.design.theme.tokenColors

/**
 * Selection & Status chips — e.g. "Visitado" (selected) / "Planejado" (unselected)
 */
@Composable
fun RagChip(
    label: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val tokens = MaterialTheme.tokenColors
    val containerColor = if (selected) tokens.secondary.main else tokens.surface.main
    val labelColor = if (selected) Color.White else tokens.text.light

    val chipModifier = if (onClick != null) {
        modifier.clickable(
            onClick = onClick,
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        )
    } else {
        modifier
    }

    Row(
        modifier = chipModifier
            .heightIn(min = 36.dp)
            .clip(RoundedCornerShape(percent = 50))
            .background(containerColor, RoundedCornerShape(percent = 50))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Checkbox(
            checked = selected,
            onCheckedChange = null,
            modifier = Modifier.size(20.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                uncheckedColor = tokens.secondary.main.copy(alpha = 0.4f),
                checkmarkColor = if (selected) Color.White else Color.Transparent
            )
        )
        RagBody(
            text = label,
            color = labelColor,
            maxLines = 1
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF1F1F1)
@Composable
private fun RagChipsPreview() {
    RagTheme {
        Surface(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RagChip(label = "Visitado", selected = true)
                RagChip(label = "Planejado", selected = false)
            }
        }
    }
}
