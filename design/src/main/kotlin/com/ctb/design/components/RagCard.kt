package com.ctb.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ctb.design.icon.RagIcons
import com.ctb.design.theme.RagTheme
import com.ctb.design.theme.tokenColors

// Card metrics from Figma
private val CARD_SHAPE = RoundedCornerShape(16.dp) // rounded-lg (2rem in Figma)
private val CARD_IMAGE_HEIGHT = 160.dp
private val CARD_CONTENT_PADDING = 12.dp

/**
 * Destination card — shows image, location name, country, photo count, and a heart (favorite) toggle.
 * Shadow + rounded-lg corners as Figma spec.
 */
@Composable
fun RagDestinationCard(
    destination: String,
    country: String,
    photoCount: Int,
    imageUrl: String?,
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    val tokens = MaterialTheme.tokenColors

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(CARD_SHAPE)
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        shape = CARD_SHAPE,
        color = tokens.surface.main,
        shadowElevation = 4.dp
    ) {
        Column {
            // ── Image area ──────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .background(tokens.surface.dark, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "$destination photo",
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )

                // Gradient overlay at bottom of image for text readability
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.3f))
                            ),
                            shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp, topStart = 0.dp, topEnd = 0.dp)
                        )
                )

                // Favorite button (top-right)
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.Black.copy(alpha = 0.3f))
                            .clickable(
                                onClick = onFavoriteClick,
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (isFavorite)
                                RagIcons.Navigation.Heart.filled
                            else
                                RagIcons.Navigation.Heart.outlined,
                            contentDescription = if (isFavorite) "Remove favorite" else "Add favorite",
                            modifier = Modifier.size(16.dp),
                            tint = if (isFavorite) tokens.accent.main else Color.White
                        )
                    }
                }
            }

            // ── Content ─────────────────────────────────
            Column(
                modifier = Modifier.padding(CARD_CONTENT_PADDING),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                RagSubtitle(
                    text = destination,
                    color = tokens.text.dark
                )
                RagCaption(
                    text = "$country \u2022 $photoCount fotos",
                    color = tokens.text.light
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF1F1F1)
@Composable
private fun RagCardsPreview() {
    RagTheme {
        LazyRow(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                RagDestinationCard(
                    destination = "Paris",
                    country = "Fran\u00e7a",
                    photoCount = 12,
                    imageUrl = null, // placeholder: shows dark bg
                    isFavorite = true
                )
            }
            item {
                RagDestinationCard(
                    destination = "Tokyo",
                    country = "Jap\u00e3o",
                    photoCount = 8,
                    imageUrl = null,
                    isFavorite = false
                )
            }
        }
    }
}
