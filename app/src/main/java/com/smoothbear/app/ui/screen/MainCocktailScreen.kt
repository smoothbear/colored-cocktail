package com.smoothbear.app.ui.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.smoothbear.app.network.dto.CocktailListData
import com.smoothbear.app.network.dto.CocktailListResponse
import com.smoothbear.app.ui.Screen
import com.smoothbear.app.ui.component.list.CocktailItem
import com.smoothbear.app.viewmodel.vm.CocktailViewModel

@Composable
fun MainCocktailScreen(
    navController: NavController,
    cocktailViewModel: CocktailViewModel
) {
    val cocktail by cocktailViewModel.cocktailListResponse.observeAsState()

    MainCocktailScreen(cocktailListResponse = cocktail) {
        navController.navigate(Screen.Detail.createRoute(it))
    }
}

@Composable
fun MainCocktailScreen(
    cocktailListResponse: CocktailListResponse?,
    onItemClick: (id: Int) -> Unit
) {

    val scrollState = rememberScrollState()
    val cocktailList by remember { mutableStateOf(cocktailListResponse) }
    val dummyData = CocktailListData(
        id = 1,
        title = "Johnnie Walker Blue Label",
        imageUrl = "https://res.cloudinary.com/dt4sawqjx/image/upload/v1463683021/eymnv9ef7lqya5nwjqa3.jpg"
    )
    val dummies = CocktailListResponse(
        cocktails = generateSequence { dummyData }.take(5).toList()
    )

    Scaffold {
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 31.dp)
                    .height(700.dp)
                    .horizontalScroll(scrollState),
                horizontalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                Spacer(Modifier.padding(0.dp))
                dummies?.let { cocktailList ->
                    cocktailList.cocktails.forEach { cocktails ->
                        CocktailItem(cocktails, onItemClick)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 20.dp)
            ) {
                Text(
                    text =
66                )
            }
        }
    }
}

@Preview
@Composable
fun MainCocktailScreenPreview() {
    val cocktailListData = CocktailListData(
        id = 1,
        title = "Johnnie Walker Blue Label",
        imageUrl = "https://res.cloudinary.com/dt4sawqjx/image/upload/v1463683021/eymnv9ef7lqya5nwjqa3.jpg"
    )

    val cocktailResponse = CocktailListResponse(
        cocktails = generateSequence { cocktailListData }.take(5).toList()
    )

    MainCocktailScreen(cocktailResponse) { }
}