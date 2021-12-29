package com.smoothbear.app.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.smoothbear.app.ui.Screen

@Composable
fun CocktailNavigation(
    navController: NavController
) {
    CocktailNavigation() {
        navController.navigate(Screen.Main.createRoute(it))
    }
}

@Composable
private fun CocktailNavigation(
    onClick: (item: NavigationItem) -> Unit
) {
    val navigationItem = listOf(NavigationItem.MainCocktail, NavigationItem.ColorCocktail)

    BottomNavigation {
        navigationItem.forEach {
            BottomNavigationItem(icon = {
                Icon(
                    imageVector = it.icon,
                    contentDescription = it.route
                )
            }, selected = false, onClick = { onClick(it) })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CocktailNavigationPreview() {
    CocktailNavigation {}
}