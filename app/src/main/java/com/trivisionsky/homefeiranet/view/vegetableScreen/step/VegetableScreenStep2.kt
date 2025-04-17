package com.trivisionsky.homefeiranet.view.vegetableScreen.step

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trivisionsky.homefeiranet.R

@Composable
fun FeiraNetVegetableStep2Screen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Feira Net") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle profile click */ }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                text = "Vegetais",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            ProductList()
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val notification = remember { mutableStateOf(false) }

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.height(50.dp)
    ) {
        NavigationBarItem(
            modifier = Modifier.size(15.dp),
            selected = true,
            onClick = { /* TODO */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Início",
                )
            },
            label = { Text("Início") }
        )
        NavigationBarItem(
            modifier = Modifier.size(15.dp),
            selected = false,
            onClick = { /* TODO */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = "Carrinho",
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text("Carrinho") }
        )

        NavigationBarItem(
            modifier = Modifier.size(15.dp),
            selected = false,
            onClick = { notification.value = false },
            icon = {
                Icon(
                    painter = if (notification.value) painterResource(id = R.drawable.ic_notification_off) else painterResource(
                        id = R.drawable.ic_notification_on
                    ),
                    contentDescription = "Notification",
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text("Notificação") }
        )

        NavigationBarItem(
            modifier = Modifier.size(15.dp),
            selected = false,
            onClick = { /* TODO */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gear),
                    contentDescription = "Config",
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text("Config") }
        )
    }
}

@Composable
fun ProductList() {
    val products = listOf(
        Product("Couve", "Boa", "Sergio dos Vegetais", 23.0, 12),
        Product("Couve", "Média", "Morena da Couve do Pecado", 16.0, 12),
        Product("Couve", "Alta", "Jefim da Couve", 28.0, 12),
        Product("Couve", "Alta", "Jefim da Couve", 28.0, 12)
    )

    LazyColumn {
        items(products) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_broccoli),
                contentDescription = "Broccoli",
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = product.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = "Qualidade: ${product.quality}", color = Color.Green)
                Text(text = "Vendedor: ${product.seller}")
                Text(text = "R$: ${product.price}   UND: ${product.quantity}")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /* Handle favorite */ }) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                }
                IconButton(onClick = { /* Handle add to cart */ }) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = "Add to Cart")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewFeiraNetScreen() {
    FeiraNetVegetableStep2Screen()
}

// Data model for the product
data class Product(
    val name: String,
    val quality: String,
    val seller: String,
    val price: Double,
    val quantity: Int
)
