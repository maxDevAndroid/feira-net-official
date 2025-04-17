package com.trivisionsky.homefeiranet.view.recoverAccount

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivisionsky.homefeiranet.R

class ForgotScreenStep1 {

    @Composable
    fun ForgotScreenSetup() {

        Scaffold(
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {

                }
            }
        )
    }


    @Composable
    fun ForgotPasswordScreen() {
        var selectedOption by remember { mutableStateOf("WhatsApp") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(150.dp))

            Text(
                text = "Esqueceu a senha ?",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Entre com o seu email ou com o seu telefone\ncelular para validar a alteracao de senha",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))

            // Option for WhatsApp
            OutlinedButton(
                onClick = { selectedOption = "WhatsApp" },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                border = BorderStroke(
                    1.dp,
                    if (selectedOption == "WhatsApp") Color(0xFFED6C02) else Color.Gray
                ),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (selectedOption == "WhatsApp") Color(0xFFFFF3E0) else Color.White
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_whatsapp),
                        contentDescription = null,
                        tint = Color(0xFF25D366),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "+12 *****28",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if (selectedOption == "WhatsApp") {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = Color(0xFFED6C02)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Option for Email
            OutlinedButton(
                onClick = { selectedOption = "Email" },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                border = BorderStroke(
                    1.dp,
                    if (selectedOption == "Email") Color(0xFFED6C02) else Color.Gray
                ),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (selectedOption == "Email") Color(0xFFFFF3E0) else Color.White
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = Color(0xFF2196F3),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "alberts*****@gmail.com",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(150.dp))

            // Continue button
            Button(
                onClick = { /* Action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFED6C02),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Continue", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }


        }

    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ForgotPasswordScreen()
    }
}