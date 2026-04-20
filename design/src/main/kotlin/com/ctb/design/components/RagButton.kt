package com.ctb.design.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctb.design.icon.RagIcons
import com.ctb.design.theme.RagTheme
import com.ctb.design.theme.tokenColors

// ── Shared metrics ──

private val ButtonHeightMin = 48.dp
private val ButtonHorizontalPadding = 32.dp
private val ButtonCornerShape = RoundedCornerShape(percent = 50) // rounded-full

// ── Primary Button (Azul Petróleo)
// High-priority actions

@Composable
fun RagPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    content: @Composable RowScope.() -> Unit
) {
    val colors = MaterialTheme.tokenColors.primary
    Button(
        onClick = onClick,
        modifier = modifier.heightIn(min = ButtonHeightMin),
        enabled = enabled,
        shape = ButtonCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.main,
            contentColor = Color.White,
            disabledContainerColor = colors.light,
            disabledContentColor = colors.dark.copy(alpha = 0.4f)
        ),
        contentPadding = PaddingValues(horizontal = ButtonHorizontalPadding)
    ) {
        if (leadingIcon != null) {
            Icon(imageVector = leadingIcon, contentDescription = null)
        }
        content()
        if (trailingIcon != null) {
            Icon(imageVector = trailingIcon, contentDescription = null)
        }
    }
}

// ── Accent Button (Laranja Memória)
// Highlights, favorites, special actions

@Composable
fun RagAccentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    content: @Composable RowScope.() -> Unit
) {
    val colors = MaterialTheme.tokenColors.accent
    Button(
        onClick = onClick,
        modifier = modifier.heightIn(min = ButtonHeightMin),
        enabled = enabled,
        shape = ButtonCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.main,
            contentColor = Color.White,
            disabledContainerColor = colors.light,
            disabledContentColor = colors.dark.copy(alpha = 0.4f)
        ),
        contentPadding = PaddingValues(horizontal = ButtonHorizontalPadding)
    ) {
        if (leadingIcon != null) {
            Icon(imageVector = leadingIcon, contentDescription = null)
        }
        content()
        if (trailingIcon != null) {
            Icon(imageVector = trailingIcon, contentDescription = null)
        }
    }
}

// ── Secondary (Outline) Button

@Composable
fun RagOutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.heightIn(min = ButtonHeightMin),
        enabled = enabled,
        shape = ButtonCornerShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.tokenColors.text.dark,
        ),
        contentPadding = PaddingValues(horizontal = ButtonHorizontalPadding)
    ) {
        if (leadingIcon != null) {
            Icon(imageVector = leadingIcon, contentDescription = null)
        }
        content()
        if (trailingIcon != null) {
            Icon(imageVector = trailingIcon, contentDescription = null)
        }
    }
}

// ── Tonal Button (light bg)

@Composable
fun RagTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    val colors = MaterialTheme.tokenColors.primary
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier.heightIn(min = ButtonHeightMin),
        enabled = enabled,
        shape = ButtonCornerShape,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = colors.light,
            contentColor = colors.dark
        ),
        contentPadding = PaddingValues(horizontal = ButtonHorizontalPadding)
    ) {
        content()
    }
}

// ── Icon Button (small)

@Composable
fun RagIconButton(
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.tokenColors.primary.main
        )
    }
}

// ── Full-width button variants

@Composable
fun RagPrimaryButtonFullWidth(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null
) {
    RagPrimaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        leadingIcon = icon,
        content = { Text(text, style = MaterialTheme.typography.bodyLarge) }
    )
}

@Composable
fun RagAccentButtonFullWidth(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null
) {
    RagAccentButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        leadingIcon = icon,
        content = { Text(text, style = MaterialTheme.typography.bodyLarge) }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF1F1F1)
@Composable
private fun RagButtonsPreview() {
    RagTheme {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { RagPrimaryButton(onClick = {}) { Text("Explorar Destinos") } }
            item { RagAccentButton(onClick = {}) { Text("Adicionar Memória") } }
            item { RagOutlineButton(onClick = {}) { Text("Cancelar") } }
            item { RagTonalButton(onClick = {}) { Text("Saiba Mais") } }
            item { RagPrimaryButtonFullWidth(onClick = {}, text = "Explorar Destinos") }
            item { RagAccentButtonFullWidth(onClick = {}, text = "Adicionar Memória") }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                item { RagIconButton(onClick = {}, icon = RagIcons.Assets.Search.filled, contentDescription = "Search") }
                item { RagIconButton(onClick = {}, icon = RagIcons.Utility.Delete, contentDescription = "Delete") }
            }
            }
        }
    }
}
