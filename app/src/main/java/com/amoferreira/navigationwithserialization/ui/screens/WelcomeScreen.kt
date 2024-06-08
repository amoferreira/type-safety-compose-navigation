package com.amoferreira.navigationwithserialization.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amoferreira.navigationwithserialization.Welcome

@Composable
fun WelcomeScreen(
    welcome: Welcome,
    onBackPressed: () -> Unit
) {
    val name = welcome.name
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 72.dp),
    ) {
        Text(
            text = "Welcome $name!",
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        Button(
            onClick = onBackPressed,
            modifier = Modifier.align(Alignment.TopStart)) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Go back"
            )
        }
    }
}