package com.lelo.d4c.models

import com.lelo.d4c.R

data class OfferCardData(
    val title: String,
    val subtitle: String,
    val date: String,
    val iconRes: Int = R.drawable.ic_heart
)