package com.trivisionsky.homefeiranet.view.loginScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivisionsky.homefeiranet.R

class LoginScreen {


    @Composable
    fun LoginScreenSetup() {

        Scaffold(
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Text("Pagina de Login")
                }
            }
        )

    }

    @Composable
    fun LoginScreen1() {

        var email by remember { mutableStateOf("estevanosilva@gmail.com") }
        var password by remember { mutableStateOf("*********") }
        var isPasswordVisible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {

            Spacer(modifier = Modifier.height(50.dp))
            // Top Section
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Logar",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Por favor, entre com sua conta",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            // Form Section
            Column {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                   // visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Default.Lock else Icons.Default.Check,
                                contentDescription = if (isPasswordVisible) "Ocultar senha" else "Mostrar senha"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Esqueceu a senha?",
                    color = Color(0xFFFF6600), // Laranja
                    modifier = Modifier.align(Alignment.End),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Button Section
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { /* Handle Login */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6600), // Laranja
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(text = "Entrar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = Color.Gray
                    )
                    Text(
                        text = "Ou entre com",
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    IconButton(onClick = { /* Google login */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Google",
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(onClick = { /* Facebook login */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "Facebook",
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(onClick = { /* Apple login */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_apple),
                            contentDescription = "Apple",
                            tint = Color.Unspecified
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
                // Bottom Section
                Text(
                    text = "Não tem uma conta? Registrar",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { /* Handle Register */ }
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LoginScreen1()
    }
}
