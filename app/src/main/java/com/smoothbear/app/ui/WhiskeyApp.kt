package com.smoothbear.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smoothbear.app.ui.main.Main
import com.smoothbear.app.viewmodel.vm.CocktailViewModel

@Composable
fun WhiskeyApp(
    viewModel: CocktailViewModel
) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "main/cocktail") {

        composable("main/cocktail") {
            Main (
               navController = navController,
               viewModel = viewModel,
               page = "list"
            )
        }

        composable(Screen.Main.route) {
            val page = it.arguments?.getString("page")
            requireNotNull(page)
            Main(navController = navController, viewModel = viewModel, page = page)
        }

        composable(Screen.Detail.route) {
            val cocktailId = it.arguments?.getString("cocktailId")
            requireNotNull(cocktailId)
        }
    }
}