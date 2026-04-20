package com.ctb.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctb.design.icon.RagIcons
import com.ctb.design.theme.RagTheme
import com.ctb.design.theme.tokenColors
import com.ctb.design.token.Spacing

// ── Top App Bar ──

@Composable
fun RagAppBar(
    userName: String,
    title: String,
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {}
) {
    val tokens = MaterialTheme.tokenColors

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(tokens.text.dark, tokens.text.dark.copy(alpha = 0.9f))
                )
            )
            .padding(horizontal = Spacing.xSmall, vertical = Spacing.xSmall),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Spacing.xxxSmall),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF2A6B76)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = RagIcons.Navigation.User.outlined,
                        contentDescription = null,
                        modifier = Modifier.size(22.dp),
                        tint = tokens.accent.main
                    )
                }
                Column {
                    RagCaption(
                        text = "Olá, $userName",
                        color = tokens.accent.main
                    )
                    RagTitle(
                        text = title,
                        color = Color.White
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable(
                        onClick = onNotificationClick,
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = RagIcons.Assets.Bell.outlined,
                    contentDescription = "Notificações",
                    tint = Color.White
                )
            }
        }
    }
}

// ── Search Bar ──

@Composable
fun RagSearchBar(
    placeholder: String = "Buscar cidade, país...",
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onFilterClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val tokens = MaterialTheme.tokenColors
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(percent = 50))
            .background(tokens.surface.main, RoundedCornerShape(percent = 50))
            .padding(horizontal = Spacing.xSmall, vertical = Spacing.xxxSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = RagIcons.Assets.Search.filled,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = tokens.text.light
        )
        androidx.compose.material3.Text(
            text = if (query.isEmpty()) placeholder else query,
            style = MaterialTheme.typography.bodyLarge,
            color = if (query.isEmpty()) tokens.text.light else tokens.text.dark,
            maxLines = 1,
            modifier = Modifier
                .weight(1f)
                .padding(start = Spacing.xxxSmall)
        )
        if (query.isNotEmpty()) {
            Icon(
                imageVector = RagIcons.Utility.Close,
                contentDescription = "Limpar",
                modifier = Modifier
                    .size(20.dp)
                    .clickable(
                        onClick = { onQueryChange("") },
                        indication = null,
                        interactionSource = interactionSource
                    ),
                tint = tokens.text.light
            )
        }
        Icon(
            imageVector = RagIcons.Utility.Tune,
            contentDescription = "Filtros",
            modifier = Modifier
                .size(24.dp)
                .clickable(
                    onClick = onFilterClick,
                    indication = null,
                    interactionSource = interactionSource
                ),
            tint = tokens.text.dark
        )
    }
}

// ── Section Header ──

@Composable
fun RagSectionHeader(
    title: String,
    linkText: String? = null,
    modifier: Modifier = Modifier,
    onLinkClick: () -> Unit = {}
) {
    val tokens = MaterialTheme.tokenColors

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = tokens.text.dark
        )
        if (linkText != null) {
            androidx.compose.material3.Text(
                text = linkText,
                style = MaterialTheme.typography.bodySmall,
                color = tokens.primary.main,
                modifier = Modifier.clickable(
                    onClick = onLinkClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF1F1F1)
@Composable
private fun RagAppBarPreview() {
    RagTheme {
        Column {
            RagAppBar(userName = "Viajante", title = "Meus Destinos")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing.xSmall),
                verticalArrangement = Arrangement.spacedBy(Spacing.xSmall)
            ) {
                RagSearchBar()
                RagSectionHeader("Suas Viagens", "Ver todas")
            }
        }
    }
}
