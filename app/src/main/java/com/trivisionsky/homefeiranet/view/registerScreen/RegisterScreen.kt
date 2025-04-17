package com.trivisionsky.homefeiranet.view.registerScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.trivisionsky.homefeiranet.R

class RegisterScreen {
    @Composable
    fun CriarContaScreen() {
        var email by remember { mutableStateOf("usuario@gmail.com") }
        var usuario by remember { mutableStateOf("usuario01") }
        var senha by remember { mutableStateOf("********") }
        var senhaVisivel by remember { mutableStateOf(false) }
        var aceitouTermos by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Criar nova Conta",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "Crie uma nova conta para poder acessar ao app FeiraNet.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(64.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuário") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                // visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = if (senhaVisivel) R.drawable.ic_visibility else R.drawable.ic_unvisible),
                            contentDescription = if (senhaVisivel) "Esconder senha" else "Mostrar senha"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = aceitouTermos,
                    onCheckedChange = { aceitouTermos = it }
                )
                DisableSelection {
                    Text(
                        text = "Eu concordo com o ",
                        color = Color.Gray
                    )
                }
                ClickableText(
                    text = AnnotatedString("Termo de Serviço"),
                    onClick = { /* Ação ao clicar */ },
                    style = LocalTextStyle.current.copy(
                        color = Color(0xFFFFA500),
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = " e ",
                    color = Color.Gray
                )

            }
            ClickableText(
                text = AnnotatedString("Política de Privacidade"),
                onClick = { /* Ação ao clicar */ },
                style = LocalTextStyle.current.copy(
                    color = Color(0xFFFFA500),
                    textDecoration = TextDecoration.Underline
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Ação ao clicar em Registrar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500))
            ) {
                Text(text = "Registrar", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Gray)
                Text(
                    text = "Ou entre com",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(16.dp))

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

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Já possui uma conta? ",
                    color = Color.Gray
                )
                ClickableText(
                    text = AnnotatedString("Logar"),
                    onClick = { /* Ação ao clicar em Logar */ },
                    style = LocalTextStyle.current.copy(
                        color = Color(0xFFFFA500),
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CriarContaScreen()
    }
}