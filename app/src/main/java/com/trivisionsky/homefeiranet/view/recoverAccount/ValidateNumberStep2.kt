package com.trivisionsky.homefeiranet.view.recoverAccount

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trivisionsky.homefeiranet.R

class ValidateNumberStep2 {

    @SuppressLint("RememberReturnType")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NumberVerificationScreen() {
        var otpCode by remember { mutableStateOf("") }
        val isCodeComplete = otpCode.length == 4
        val focusRequesters = List(4) { FocusRequester() }
        // val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        LaunchedEffect(otpCode) {
            if (otpCode.length == 4) {
                focusManager.clearFocus()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.ic_back_button),
                    contentDescription = null,
                    tint = Color.Black
                )

                Text(
                    fontSize = 24.sp,
                    text = "OTP",
                    color = Color.Black,
                )
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = Color.White
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            Text(
                fontSize = 24.sp,
                text = "Validar o número",
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "Insira o código de verificacao enviado para\n o seu número:",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                Text(
                    text = "+12 * ****-**28",
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
            }



            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),

                ) {

                var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }


                repeat(4) { index ->


                    TextField(
                        value = textFieldValue,
                        onValueChange = { newValue: TextFieldValue ->
                            if (newValue.text.length == 1 && newValue.text.all { it.isDigit() }) {
                                otpCode =
                                    otpCode.take(index) + newValue.text + otpCode.drop(index + 1)

                                // Move to next field automatically
                                if (index < 3) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            } else if (newValue.text.isEmpty() && index > 0) {
                                // Go to previous field if the user deletes the value
                                focusRequesters[index - 1].requestFocus()
                            }
                            // Update the TextField's value
                            textFieldValue = newValue
                        },
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.White)
                            .focusRequester(focusRequesters[index])
                            .border(
                                BorderStroke(
                                    1.dp,
                                    Color(0xFFEAEAEA)
                                )
                            ),
                        //keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        shape = RoundedCornerShape(20.dp),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        ),
                        singleLine = true,
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }
            }

            TextButton(onClick = { /* Reenviar código */ }) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Não recebeu o código?",
                        color = Color(0xFF878787)
                    )

                    Text(
                        text = "Reenviar",
                        color = Color(0xFFFC6000)
                    )
                }

            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = Color.Black
                )

                Text(
                    text = "09:00",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

            }

            Button(
                onClick = { /* Continuar */ },
                enabled = isCodeComplete,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6600),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),

                ) {
                Text(text = "Continue", fontSize = 18.sp)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        NumberVerificationScreen()
    }


}