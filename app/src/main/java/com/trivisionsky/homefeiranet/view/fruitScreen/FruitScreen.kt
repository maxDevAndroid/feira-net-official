package com.trivisionsky.homefeiranet.view.fruitScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivisionsky.homefeiranet.R

@Preview(showBackground = true)
@Composable
fun FeiraNetAppPreview() {
    FeiraNetFruitScreen()
}

@Composable
fun FeiraNetFruitScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 16.dp)

        ) {

            Spacer(modifier = Modifier.height(24.dp))
            CategoriesSection()

            Spacer(modifier = Modifier.height(24.dp))
            ProductsSection({
                /*TODO: AO CLICAR NO FILTER LEVA PARA A PAGINA DE FILTROS*/
            })

        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Feira Net", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = { /* Profile click */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile"
            )
        }
    }
}

@Composable
fun CategoriesSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CategoryItem(
            name = "Frutas",
            iconRes = R.drawable.ic_fruit
        ) {/*Ao clicar direcione para tela de frutas*/ }
        CategoryItem(
            name = "Vegetais",
            iconRes = R.drawable.ic_vegetable
        ) {/* Ao clicar direcione para a tela de vegetais*/ }

        Spacer(modifier = Modifier.weight(1f))


    }
}

@Composable
fun CategoryItem(name: String, iconRes: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = iconRes), contentDescription = name)
        }
        Text(text = name, fontSize = 12.sp)
    }
}

@Composable
fun ProductsSection(onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Frutas",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onClick() }) {
            Text(text = "Filtro", fontSize = 24.sp)
            Icon(
                painterResource(R.drawable.ic_filter),
                contentDescription = "Filter",
                modifier = Modifier.size(48.dp)
            )
        }


    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    val favorite = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFF6E40),
                            Color(0xFFFFD740)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = product.name,
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {

                    Text(text = product.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "UND: ${product.und}", fontSize = 16.sp)

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(text = "R$: ${product.price}", fontSize = 16.sp)

                }

                IconButton(onClick = { /* Add to cart */ }) {
                    Icon(
                        painter = if (favorite.value) painterResource(id = R.drawable.ic_heart) else painterResource(
                            id = R.drawable.ic_favorite
                        ),
                        contentDescription = "Add to Cart"
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val notification = remember { mutableStateOf(false) }

    NavigationBar(
        containerColor = Color.Unspecified,
        contentColor = Color.Black,
        modifier = Modifier
            .height(50.dp)
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


val products = listOf(
    Product("Laranja Seleta", 20.00, 12, R.drawable.ic_orange),
    Product("Melancia", 10.00, 3, R.drawable.ic_watermelon),
    Product("Coco", 12.00, 15, R.drawable.ic_coconut),
    Product("Uvas", 15.00, 32, R.drawable.ic_grapes)
)

data class Product(val name: String, val price: Double, val und: Int, val imageRes: Int)
