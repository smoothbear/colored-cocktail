package com.smoothbear.app.ui.component

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smoothbear.app.di.App
import com.smoothbear.app.network.dto.CocktailData

@Composable
fun CocktailItem(
    cocktail: CocktailData,
    onItemClick: (id: Int) -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable { onItemClick(cocktail.id) }
    ) {
        Column (
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            Text(text = cocktail.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = cocktail.description, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CocktailItemPreview() {
    val cocktailData = CocktailData (
        id = 1,
        title = "Johnnie Walker Blue Label",
        description = "This is an excellent whiskey with notes of fruit and a strong finish. Accesible, but also complex enough for a seasoned drinker.",
        location = "Scotland",
        price = 157,
        imageUrl = "https://res.cloudinary.com/dt4sawqjx/image/upload/v1463683021/eymnv9ef7lqya5nwjqa3.jpg"
    )
    
    CocktailItem(cocktail = cocktailData) {
        Toast.makeText(App.getApplicationContext(), "Cocktail is clicked!!", Toast.LENGTH_SHORT).show()
    }
}