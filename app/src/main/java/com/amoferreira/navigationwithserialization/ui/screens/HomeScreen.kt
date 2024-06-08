package com.amoferreira.navigationwithserialization.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onNavigateClick: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 72.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello!",
            fontSize = 36.sp,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "This is an app to test the Type Safety in Navigation using Compose.\n" +
                    "Insert your name and navigate to the next screen!",
            fontSize = 20.sp,
            lineHeight = 28.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = name,
            onValueChange = { name = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { onNavigateClick(name) },
            enabled = name.isNotBlank()
        ) {
            Text(
                text = "Next screen",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}