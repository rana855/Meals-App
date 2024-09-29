package com.example.mealsappodc.ui.screens.mainscreen

import android.text.Layout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip

@Preview(showBackground = true)
@Composable
fun MealItem(modifier: Modifier = Modifier, title: String = "Meal", imageUrl: String = "", function : () -> Unit = {}) {
    Card(
        modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp).clickable { function() }, shape = CircleShape, colors = CardDefaults.cardColors(Color.White), elevation = CardDefaults.cardElevation(5.dp)) {
        Row(modifier = Modifier.fillMaxSize().padding(start = 30.dp,end=30.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {

            AsyncImage(model = imageUrl, contentDescription = "Meal Image" , contentScale = ContentScale.Crop , modifier = Modifier
                .size(50.dp)
                .clip(CircleShape))

            Text(text = title)

        }

    }
}