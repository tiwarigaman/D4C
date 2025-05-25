package com.lelo.d4c.screeens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lelo.d4c.R
import com.lelo.d4c.models.CategoryItem

@Composable
fun CategoriesSection(
    categories: List<CategoryItem>,
    modifier: Modifier = Modifier,
    onSeeAllClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(Color(0xFF232323))
            .padding(vertical = 16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Categories",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                "See all",
                color = Color.White,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .clickable { onSeeAllClick() }
            )
        }
        Spacer(Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(categories.size) { index ->
                val category = categories[index]
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(90.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(84.dp)
                            .background(Color.Black, shape = CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = category.imageRes),
                            contentDescription = category.label,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        category.label,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 2.dp),
                        maxLines = 1
                    )
                }
            }
        }
    }
}
