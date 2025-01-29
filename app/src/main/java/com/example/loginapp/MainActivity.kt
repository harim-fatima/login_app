package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var loginText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp)) // Spacer between title and fields

        TextField(
            value = loginText,
            onValueChange = { loginText = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Username") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password text field
        TextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Submit Button
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    LoginAppTheme {
        LoginForm()
    }
}
