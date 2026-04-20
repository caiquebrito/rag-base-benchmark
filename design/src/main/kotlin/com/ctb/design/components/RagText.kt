package com.ctb.design.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctb.design.theme.RagTheme

// ── Generic Text (flexible text with any style)

@Composable
fun RagText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun RagText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

// ── Title (Título Principal)
// Spline Sans Bold 24px ──

@Composable
fun RagTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.displayLarge
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

// ── Subtitle (Subtítulo de Seção)
// Spline Sans SemiBold 20px ──

@Composable
fun RagSubtitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

// ── Body (travel descriptions & details)
// Spline Sans Regular 16px ──

@Composable
fun RagBody(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

// ── Caption (secondary info, labels)
// Spline Sans Medium 12px ──

@Composable
fun RagCaption(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF1F1F1)
@Composable
private fun RagTypographyPreview() {
    RagTheme {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { RagTitle("Título Principal") }
            item { RagSubtitle("Subtítulo de Seção") }
            item { RagBody("Este é o corpo do texto usado para descrições de viagens e detalhes de memórias.") }
            item { RagCaption("Legendas e informações secundárias") }
        }
    }
}
