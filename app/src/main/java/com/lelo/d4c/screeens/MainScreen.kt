package com.lelo.d4c.screeens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lelo.d4c.R
import com.lelo.d4c.models.OfferCardData

@Composable
fun SwipableOfferCards(offerCards: List<OfferCardData>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = { offerCards.size })
    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 20.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        ) { page ->
            OfferCard(
                data = offerCards[page],
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            Modifier
                .padding(start = 60.dp)
                .offset(y = (-16).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            offerCards.forEachIndexed { idx, _ ->
                Box(
                    Modifier
                        .width(if (pagerState.currentPage == idx) 32.dp else 16.dp)
                        .height(9.dp)
                        .background(
                            if (pagerState.currentPage == idx) Color(0xFFA9FF41) else Color(
                                0xFF111111
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
                Spacer(Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun OfferCard(
    data: OfferCardData,
    cardBgRes: Int = R.drawable.offer_icon,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        Image(
            painter = painterResource(id = cardBgRes),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 22.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        data.title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        data.subtitle,
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(14.dp))
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFA9FF41), shape = RoundedCornerShape(14.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(data.date, color = Color.Black, fontSize = 13.sp)
                    }
                }
                Spacer(Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Bottom)
                )
            }
        }
    }
}
