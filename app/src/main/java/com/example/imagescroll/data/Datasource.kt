package com.example.imagescroll.data

import com.example.imagescroll.R
import com.example.imagescroll.model.ImageItem

class Datasource {
    fun loadImages(): List<ImageItem> {
        // Gunakan R.drawable.ic_launcher_background yang pasti ada di project
        val defaultImage = R.drawable.ic_launcher_background

        return listOf(
            ImageItem(
                "Mountain Landscape",
                "Beautiful mountain landscape with snow-capped peaks and green valleys.",
                R.drawable.image1
            ),
            ImageItem(
                "Beach Sunset",
                "Stunning beach sunset with orange and purple sky over the ocean.",
                R.drawable.image2
            ),
            ImageItem(
                "Forest Path",
                "Serene forest path with sunlight filtering through the trees.",
                R.drawable.image1
            ),
            ImageItem(
                "City Skyline",
                "Modern city skyline with skyscrapers and lights at dusk.",
                R.drawable.image5
            ),
            ImageItem(
                "Desert Dunes",
                "Golden desert dunes stretching as far as the eye can see.",
                R.drawable.image4
            ),
        )
    }
}