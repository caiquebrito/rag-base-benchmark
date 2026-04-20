package com.ctb.design.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Flight
import androidx.compose.material.icons.outlined.Hotel
import androidx.compose.material.icons.outlined.Luggage
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Map
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Central mapping of all app icons to Material icons.
 * Active (filled) and inactive (outlined) variants for each.
 *
 * Usage:
 *   RagIcons.Navigation.Explore
 *   RagIcons.Assets.Flight
 *   RagIcons.Navigation.filled.Explore
 */
open class IconGroup

object RagIcons {

    object Navigation : IconGroup() {
        val Home = IconPair(Icons.Filled.Home, Icons.Outlined.Home)
        val Map = IconPair(Icons.Filled.Map, Icons.Outlined.Map)
        val Heart = IconPair(Icons.Filled.Favorite, Icons.Outlined.Favorite)
        val User = IconPair(Icons.Filled.Person, Icons.Outlined.Person)
    }

    object Assets : IconGroup() {
        val Flight = IconPair(Icons.Filled.Flight, Icons.Outlined.Flight)
        val Hotel = IconPair(Icons.Filled.Hotel, Icons.Outlined.Hotel)
        val Camera = IconPair(Icons.Filled.PhotoCamera, Icons.Outlined.PhotoCamera)
        val Globe = IconPair(Icons.Filled.Public, Icons.Outlined.Public)
        val Bag = IconPair(Icons.Filled.Luggage, Icons.Outlined.Luggage)
        val Ticket = IconPair(Icons.Filled.ConfirmationNumber, Icons.Outlined.ConfirmationNumber)
        val Check = IconPair(Icons.Filled.CheckCircle, Icons.Outlined.CheckCircle)
        val Star = IconPair(Icons.Filled.Star, Icons.Outlined.Star)
        val Search = IconPair(Icons.Filled.Search, Icons.Outlined.Search)
        val Bell = IconPair(Icons.Filled.Notifications, Icons.Outlined.Notifications)
    }

    object Utility {
        val ArrowBack = Icons.Filled.ArrowBack
        val Close = Icons.Filled.Close
        val MoreVert = Icons.Filled.MoreVert
        val Share = Icons.Filled.Share
        val Edit = Icons.Filled.Edit
        val Delete = Icons.Filled.Delete
        val Add = Icons.Filled.Add
        val Tune = Icons.Filled.Tune
        val Flag = Icons.Filled.Flag
        val Landscape = Icons.Filled.Landscape
        val NearMe = Icons.Filled.NearMe
    }
}

/**
 * Pair of filled (active) and outlined (inactive) icons for a single concept.
 */
@Immutable
data class IconPair(
    val filled: ImageVector,
    val outlined: ImageVector
)

/**
 * Icon state color tokens — matches the yellow active / gray inactive spec.
 */
object RagIconColors {
    val Active = Color(0xFFF4A261)   // Laranja Memória main — active tint
    val Inactive = Color(0xFFB0BEC5) // Blue-gray-200 — inactive/default tint
}
