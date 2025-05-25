package com.lelo.d4c

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lelo.d4c.models.*
import com.lelo.d4c.screeens.*
import com.lelo.d4c.ui.theme.D4CTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            D4CTheme {
                ShopScreen()
            }
        }
    }
}

val sampleOfferCards = listOf(
    OfferCardData(
        title = "GET 20% OFF",
        subtitle = "Get 20% off",
        date = "12-16 October",
        iconRes = R.drawable.offer_icon
    ),
    OfferCardData(
        title = "GET 10% OFF",
        subtitle = "Get 10% off",
        date = "17-20 October",
        iconRes = R.drawable.offer_icon
    )
)


val sampleCategoriesList = listOf(
    CategoryItem("Cleaners", R.drawable.cleaner),
    CategoryItem("Toner", R.drawable.cleaner),
    CategoryItem("Serums", R.drawable.cleaner),
    CategoryItem("Moisturisers", R.drawable.cleaner)
)


val sampleProducts = listOf(
    Product(
        title = "cleancer",
        subtitle = "French Clay and algae\nSkin Tightness • Dehydrated Skin",
        imageRes = R.drawable.cleaner,
        isBestSeller = true,
        price = "RS. 359.20",
        originalPrice = "RS. 449.00",
        rating = 4.5f,
        reviewCount = 246,
        isInStock = true
    ),
    Product(
        title = "glow",
        subtitle = "For all skin types\nSkin Tightness • Dehydrated Skin",
        imageRes = R.drawable.cleaner,
        isBestSeller = false,
        price = "RS. 359.20",
        originalPrice = "RS. 449.00",
        rating = 4.0f,
        reviewCount = 200,
        isInStock = true
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen() {
    Scaffold(
        topBar = { ShopTopBar() },
        containerColor = Color(0xFF232323)
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF232323))
                .padding(innerPadding)
        ) {
            item {
                OfferCardSection()
                Spacer(Modifier.height(24.dp))
            }
            item {
                CategoriesSectionSection()
                Spacer(Modifier.height(24.dp))
            }
            items(sampleProducts.size) { idx ->
                ProductCardCustom(product = sampleProducts[idx])
            }
        }
    }
}

@Composable
fun OfferCardSection() {
    SwipableOfferCards(offerCards = sampleOfferCards)
}

@Composable
fun CategoriesSectionSection() {
    CategoriesSection(categories = sampleCategoriesList)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopTopBar() {
    TopAppBar(
        title = {
            Text("Shop", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 22.sp)
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White, modifier = Modifier.size(28.dp))
            }
            BadgeIcon(imageRes = R.drawable.ic_heart, badgeCount = 5)
            BadgeIcon(imageRes = R.drawable.ic_cart, badgeCount = 3)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF232323)
        )
    )
}

@Composable
fun BadgeIcon(imageRes: Int, badgeCount: Int) {
    Box(contentAlignment = Alignment.TopEnd) {
        Icon(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            tint = Color(0xFFFFFFFF),
            modifier = Modifier.size(28.dp)
        )
        if (badgeCount > 0) {
            Box(
                Modifier
                    .size(18.dp)
                    .background(Color(0xFFA9FF41), shape = CircleShape)
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "$badgeCount",
                    color = Color.Black,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
