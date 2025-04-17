package com.trivisionsky.homefeiranet.view.recoverAccount

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivisionsky.homefeiranet.R

class ChangePassStep3 {

    @Composable
    fun NovaSenhaScreen() {

        var newPass by remember { mutableStateOf("") }
        var confirmPass by remember { mutableStateOf("") }
        var visiblePass by remember { mutableStateOf(false) }
        var confirmVisiblePass by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)

            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.ic_back_button),
                    contentDescription = null,
                    tint = Color.Black
                )

                Text(
                    fontSize = 24.sp,
                    text = "Nova Senha",
                    color = Color.Black,
                )
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Insira nova Senha",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sua senha nova deve ser diferente \n das senhas anteriores.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Nova Senha",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )


            TextField(
                value = newPass,
                onValueChange = { newPass = it },
                label = { Text("*********") },
                visualTransformation = if (visiblePass) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { visiblePass = !visiblePass }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = if (visiblePass) R.drawable.ic_visibility else R.drawable.ic_unvisible),
                            contentDescription = if (visiblePass) "Esconder senha" else "Mostrar senha"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, Color.Black))
            )
            Text(
                text = "Deve conter pelo menos 8 caracteres.",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Confirmar Nova Senha",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            // Confirmar Nova Senha
            TextField(
                value = confirmPass,
                onValueChange = { confirmPass = it },
                label = { Text("*********") },
                visualTransformation = if (confirmVisiblePass) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { confirmVisiblePass = !confirmVisiblePass }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = if (confirmVisiblePass) R.drawable.ic_visibility else R.drawable.ic_unvisible),
                            contentDescription = if (confirmVisiblePass) "Esconder senha" else "Mostrar senha"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, Color.Black))
            )
            Text(
                text = "As duas senhas devem ser iguais.",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(350.dp))

            // Botão
            Button(
                onClick = { /* Ação de trocar senha */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500))
            ) {
                Text(text = "Atualizar", color = Color.White, fontSize = 16.sp)
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        NovaSenhaScreen()
    }

}