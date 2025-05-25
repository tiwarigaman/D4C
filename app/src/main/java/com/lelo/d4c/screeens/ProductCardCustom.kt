package com.lelo.d4c.screeens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lelo.d4c.R
import com.lelo.d4c.models.Product

@Composable
fun ProductScreen(modifier: Modifier = Modifier, products: List<Product>) {
    Column(
        modifier = modifier
            .background(Color(0xFF232323))
            .padding(top = 16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "New products",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White
            )
            Text(
                "See all",
                color = Color(0xFFB5F535),
                fontSize = 15.sp,
                modifier = Modifier.clickable {  }
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            items(products.size) { product ->
                ProductCardCustom(product = products[product])
            }
        }
    }
}



@Composable
fun ProductCardCustom(product: Product, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.84f)
            .padding(bottom = 24.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_card),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )


        if (product.isBestSeller) {
            Box(
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 18.dp)
                    .background(
                        color = Color.Black,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(18.dp)
                    )
                    .padding(horizontal = 14.dp, vertical = 5.dp)
            ) {
                Text(
                    "Best seller",
                    color = Color(0xFFB5F535),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }


        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 38.dp)
                .size(250.dp)
        )


        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(200.dp)
                .padding(20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.card_black_shape),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )


            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 68.dp, top = 14.dp, bottom = 14.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        product.title,
                        color = Color(0xFFB5F535),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                    if (product.isInStock) {
                        Spacer(Modifier.width(10.dp))
                        Text(
                            "In stock",
                            color = Color(0xFFB5F535),
                            fontSize = 12.sp
                        )
                    }
                }
                Text(
                    product.subtitle,
                    color = Color.White,
                    fontSize = 12.sp
                )
                Spacer(Modifier.height(3.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        product.price,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        product.originalPrice,
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                }

                Spacer(Modifier.width(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {


                    repeat(product.rating.toInt()) {
                        Icon(
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = null,
                            tint = Color(0xFFFFD600),
                            modifier = Modifier.size(15.dp)
                        )
                    }
                    Text(
                        "  ${product.reviewCount} reviews",
                        color = Color(0xFFB5F535),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, top = 20.dp)
                    .size(38.dp)
                    .background(Color(0xFFB5F535), shape = CircleShape)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center,

            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add to Cart",
                    tint = Color.Black,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}
