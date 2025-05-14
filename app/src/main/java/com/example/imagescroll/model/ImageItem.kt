package com.example.imagescroll.model

import androidx.annotation.DrawableRes

data class ImageItem(
    val title: String,
    val description: String,
    @DrawableRes val imageResourceId: Int
)