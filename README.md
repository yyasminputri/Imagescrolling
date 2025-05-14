## 📘 Pendahuluan
Proyek ini adalah aplikasi Android sederhana yang dibuat menggunakan Jetpack Compose, framework deklaratif dari Google untuk membangun UI Android. Fokus utama dari aplikasi ini adalah menampilkan daftar gambar yang dapat discroll (scrollable image list).

Tujuan utama dari proyek ini bisa jadi untuk:
- Belajar dasar-dasar Jetpack Compose
- Menerapkan konsep LazyColumn / LazyRow
- Menampilkan UI berbasis data menggunakan image resources

## 🛠️ Langkah-Langkah Pembuatan Proyek

Berikut langkah-langkah pembuatan proyek seperti ini menggunakan Jetpack Compose:
1. Inisialisasi Proyek
- Buat proyek Android Studio baru dengan template "Empty Compose Activity"
- Pilih bahasa Kotlin dan aktifkan Jetpack Compose support

2. Struktur Folder

Imagescroll/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── imagescroll/
│   │   │   │               ├── MainActivity.kt
│   │   │   │               ├── data/
│   │   │   │               │   └── Datasource.kt
│   │   │   │               ├── model/
│   │   │   │               │   └── ImageItem.kt
│   │   │   │               └── ui/
│   │   │   │                   └── theme/
│   │   │.  │                   └── color/
│   │   │   │                   └── strings/
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── image1.png
│   │   │   │   │   ├── image2.png
│   │   │   │   │   ├── image3.png
│   │   │   │   │   └── ...
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── themes.xml
│   │   │   │   │   └── strings.xml
│   │   │   └── AndroidManifest.xml
├── build.gradle
├── settings.gradle
└── gradle.properties

3. Menambahkan Gambar ke Drawable
Tambahkan gambar ke dalam folder res/drawable
4. Membuat List Data
Buat list berisi nama-nama resource gambar
5. Menggunakan LazyColumn atau LazyRow
Gunakan LazyColumn atau LazyRow dari Jetpack Compose untuk membuat scrollable list
Tampilkan gambar menggunakan Image(painter = painterResource(id = R.drawable.nama_gambar))
6. Menjalankan dan Testing di Emulator

## 📦 Isi Proyek dan Komponen Utama
Berdasarkan struktur file, beberapa komponen penting adalah:
- MainActivity.kt: Tempat utama UI didefinisikan menggunakan Jetpack Compose
- build.gradle.kts: Build script untuk mengatur dependensi, termasuk Jetpack Compose
- res/drawable: Tempat penyimpanan gambar yang akan discroll
- Datasource.kt: Sumber data yang mengembalikan list ImageItem.
- ImageItem: Model data yang merepresentasikan satu gambar.

### 📌 MainActivity.kt
```
package com.example.imagescroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imagescroll.data.Datasource
import com.example.imagescroll.model.ImageItem
import com.example.imagescroll.ui.theme.ImageScrollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageScrollTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageScrollApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScrollApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "ImageScroll",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorites")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                }
            }
        }
    ) { innerPadding ->
        ImageGalleryContent(innerPadding)
    }
}

@Composable
fun ImageGalleryContent(paddingValues: PaddingValues) {
    val imageList = Datasource().loadImages()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        // Featured images section
        Text(
            text = "Featured Images",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(imageList.take(5)) { item ->
                FeaturedImageCard(item)
            }
        }

        // All images section
        Text(
            text = "All Images",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp, 24.dp, 16.dp, 8.dp)
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 12.dp,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(imageList) { item ->
                ImageCard(item)
            }
        }
    }
}

@Composable
fun FeaturedImageCard(image: ImageItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .width(280.dp)
            .height(180.dp)
    ) {
        Box {
            Image(
                painter = painterResource(image.imageResourceId),
                contentDescription = image.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )
            Text(
                text = image.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ImageCard(image: ImageItem) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(image.imageResourceId),
                    contentDescription = image.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.7f))
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                        tint = if (isFavorite) Color.Red else Color.Black
                    )
                }
            }
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = image.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = image.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageScrollAppPreview() {
    ImageScrollTheme {
        ImageScrollApp()
    }
}
```

### 📌 Datasource.kt
```
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
```

### 📌 ImageItem.kt
```
package com.example.imagescroll.model

import androidx.annotation.DrawableRes

data class ImageItem(
    val title: String,
    val description: String,
    @DrawableRes val imageResourceId: Int
)
```

## 🪜 4. Langkah-Langkah Pembuatan
- Buat model data → ImageItem.kt
- Buat data dummy → Datasource.kt
- Bangun UI utama → MainActivity.kt
- Gunakan LazyRow dan LazyVerticalStaggeredGrid
- Tambahkan gambar di res/drawable
- Jalankan dan testing

## 📌 Penjelasan Kode
- imageList: List yang berisi referensi gambar dari drawable
- LazyRow: Menampilkan gambar secara horizontal (scroll ke samping)
- LazyVerticalStaggeredGrid: Menampilkan gambar dalam format grid tak beraturan secara vertikal
- ImagescrollTheme: Tema custom yang dibuat di folder ui.theme

## Preview App
<img width="148" alt="Screenshot 2025-05-14 at 10 34 55" src="https://github.com/user-attachments/assets/88f7c1c7-1099-4e17-985f-5df5e27c2a49" />
