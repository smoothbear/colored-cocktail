package com.smoothbear.app.ui.component.list

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.smoothbear.app.di.App
import com.smoothbear.app.network.dto.CocktailListData

@Composable
fun CocktailItem(
    cocktail: CocktailListData,
    onItemClick: (id: Int) -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(370.dp)
            .height(700.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable { onItemClick(cocktail.id) }
    ) {
        Box {
            Image(
                painter = rememberImagePainter(cocktail.imageUrl),
                contentDescription = cocktail.title + "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.DarkGray),
                contentScale = ContentScale.Crop,
            )

            Text(
                text = cocktail.title,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                textAlign = TextAlign.Left,
                softWrap = true,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 30.dp, top = 450.dp)
                    .width(200.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CocktailItemPreview() {
    val cocktailData = CocktailListData (
        id = 1,
        title = "Johnnie Walker Blue Label",
        imageUrl = "https://res.cloudinary.com/dt4sawqjx/image/upload/v1463683021/eymnv9ef7lqya5nwjqa3.jpg"
    )
    
    CocktailItem(cocktail = cocktailData) {
        Toast.makeText(App.getApplicationContext(), "Cocktail is clicked!!", Toast.LENGTH_SHORT).show()
    }
}