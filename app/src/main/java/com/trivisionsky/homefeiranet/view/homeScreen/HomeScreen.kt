package com.trivisionsky.homefeiranet.view.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.trivisionsky.homefeiranet.R


    @Composable
    fun FeiraNetApp() {
        Scaffold(
            topBar = { AppBar() },
            bottomBar = { BottomNavigationBar() }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                CategoriesSection()
                AuctionSection()

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "Promoções",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFA726)
                )
                Spacer(modifier = Modifier.height(5.dp))
                PromotionsSection()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppBar() {
        TopAppBar(
            modifier = Modifier.padding(20.dp),
            title = {},
            colors = TopAppBarColors(
                containerColor = Color.White,
                scrolledContainerColor = Color.Black,
                navigationIconContentColor = Color.Black,
                titleContentColor = Color.Black,
                actionIconContentColor = Color.Black,
            ),

            actions = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Menu"
                        )
                    }

                    Text(text = "Feira Net", fontWeight = FontWeight.Bold, fontSize = 32.sp)

                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = "User Profile"
                        )
                    }
                }

            }
        )
    }

    @Composable
    fun CategoriesSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "User Profile"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            CategoryItem("Frutas", R.drawable.ic_fruit)
            CategoryItem("Vegetais", R.drawable.ic_vegetable)
        }
    }

    @Composable
    fun CategoryItem(name: String, iconRes: Int) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // TODO: FAZER VALIDACAO SE CLICADO FRUTAS ,COLOCA UM STOKE VERMELHO AO REDOR O MESMO AO CONTRARIO  SE N CLICADO MANTEM O ESTADO NORMAL DE SEM CIRCLE
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = name,
                modifier = Modifier
                    .size(72.dp)
                    .padding(8.dp)
            )
            Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }
    }

    @Composable
    fun AuctionSection() {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Leilão do dia",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            //TODO: TRANSFORMAR ESSE ROW EM LAZYROW LISTA DE ITENS
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                AuctionItem(
                    "Laranja Seleta",
                    "R$ 20,00",
                    "12",
                    R.drawable.ic_orange,
                    Modifier
                        .weight(1f)
                )
                AuctionItem(
                    "Melancia", "R$ 10,00", "1",
                    R.drawable.ic_watermelon, Modifier
                        .weight(1f)
                )
            }
        }
    }

    @Composable
    fun AuctionItem(name: String, price: String, und: String, imageRes: Int, modifier: Modifier) {

        val isFavorite by remember { mutableStateOf(false) }
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = modifier
                .width(100.dp)
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = name,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 16.sp
                        )

                        IconButton(onClick = { /* Google login */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = "Ic_Cart",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(32.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.3f)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .shadow(20.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Und: $und", fontSize = 16.sp, color = Color.White)

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Text(text = price, fontSize = 16.sp, color = Color.White)

                        IconButton(onClick = { isFavorite != isFavorite }) {
                            Icon(
                                painter = if (isFavorite) painterResource(id = R.drawable.ic_heart) else painterResource(
                                    id = R.drawable.ic_favorite
                                ),
                                contentDescription = "Ic_Cart",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(32.dp)
                            )
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun PromotionsSection() {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color(0xFFFFF3E0)),
            modifier = Modifier.fillMaxWidth()
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
                Column(modifier = Modifier.padding(16.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {

                        Text(
                            text = "Compre hoje R$ 20,00 e GANHE R$ 2,00 de Desconto",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        // TODO: Consertar o icone n apareece na Row no canto direito
                        Icon(
                            painter = painterResource(id = R.drawable.ic_watermelon_background),
                            contentDescription = "Ic_Cart",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(20.dp)
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Regras da sale",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                }
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

    @Preview(showBackground = true)
    @Composable
    fun FeiraNetAppPreview() {
        FeiraNetApp()
    }
