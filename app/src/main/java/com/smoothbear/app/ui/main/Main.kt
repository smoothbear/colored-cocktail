package com.smoothbear.app.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.smoothbear.app.viewmodel.vm.CocktailViewModel

@Composable
fun Main(
    navController: NavController,
    viewModel: CocktailViewModel,
    page: String
) {
    Scaffold (
        bottomBar = { CocktailNavigation(navController = navController) }
    ) {
        when (page) {
            NavigationItem.MainCocktail.route -> {
                
            }

            NavigationItem.ColorCocktail.route -> {

            }
        }
    }
}