package com.smoothbear.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.smoothbear.app.network.dto.CocktailResponse
import com.smoothbear.app.ui.Screen
import com.smoothbear.app.ui.main.CocktailNavigation
import com.smoothbear.app.viewmodel.vm.CocktailViewModel

@Composable
fun MainCocktailScreen (
    navController: NavController,
    cocktailViewModel: CocktailViewModel
) {
    val cocktail by cocktailViewModel.cocktailResponse.observeAsState()
    
    MainCocktailScreen(cocktailResponse = cocktail, navController = navController) {
        navController.navigate(Screen.Detail.createRoute(it))
    }
}

@Composable
fun MainCocktailScreen (
    cocktailResponse: CocktailResponse?,
    navController: NavController,
    onItemClick: (id: Int) -> Unit
) {

    val listState = rememberLazyListState()
    var cocktailList by remember { mutableStateOf(cocktailResponse) }

    Scaffold (
        bottomBar = { CocktailNavigation(navController) }
    ) {
        Column {
            LazyColumn(state = listState) {
                cocktailList?.let { }
            }
        }
    }
}