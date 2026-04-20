package com.ctb.design.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctb.design.icon.RagIcons
import com.ctb.design.theme.RagTheme
import com.ctb.design.theme.tokenColors

/**
 * Bottom navigation item definition.
 */
@Immutable
data class RagNavItem(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon
)

/**
 * Bottom navigation bar following the app color tokens.
 */
@Composable
fun RagBottomNavBar(
    items: List<RagNavItem>,
    currentRoute: String,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val tokens = MaterialTheme.tokenColors
    NavigationBar(
        modifier = modifier,
        containerColor = tokens.surface.main,
        contentColor = tokens.text.light,
        tonalElevation = 8.dp
    ) {
        items.forEach { item ->
            val isSelected = item.label == currentRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(item.label) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp),
                        tint = if (isSelected) tokens.primary.main else tokens.text.light
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = tokens.primary.main,
                    unselectedIconColor = tokens.text.light,
                    selectedTextColor = tokens.primary.main,
                    unselectedTextColor = tokens.text.light,
                    indicatorColor = Color.Transparent
                ),
                alwaysShowLabel = false
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF1F1F1)
@Composable
private fun RagBottomNavBarPreview() {
    RagTheme {
        val navItems = listOf(
            RagNavItem("Home", RagIcons.Navigation.Home.filled, RagIcons.Navigation.Home.outlined),
            RagNavItem("Map", RagIcons.Navigation.Map.filled, RagIcons.Navigation.Map.outlined),
            RagNavItem("Favorites", RagIcons.Navigation.Heart.filled, RagIcons.Navigation.Heart.outlined),
            RagNavItem("Profile", RagIcons.Navigation.User.filled, RagIcons.Navigation.User.outlined)
        )
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { RagBottomNavBar(items = navItems, currentRoute = "Explore", onNavigate = {}) }
            item { RagBottomNavBar(items = navItems, currentRoute = "Favorites", onNavigate = {}) }
        }
    }
}
