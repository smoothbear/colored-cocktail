package com.smoothbear.app.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector) {
    object MainCocktail : NavigationItem("list", Icons.Outlined.ShoppingCart)
    object ColorCocktail : NavigationItem("color", Icons.Outlined.Place)
}
