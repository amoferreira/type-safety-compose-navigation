package com.amoferreira.navigationwithserialization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.amoferreira.navigationwithserialization.ui.screens.HomeScreen
import com.amoferreira.navigationwithserialization.ui.screens.WelcomeScreen
import com.amoferreira.navigationwithserialization.ui.theme.NavigationWithSerializationTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWithSerializationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Home) {
                    composable<Home> {
                        HomeScreen(
                            onNavigateClick = { name ->
                                navController.navigate(Welcome(name))
                            }
                        )
                    }
                    composable<Welcome> { navBackStackEntry ->
                        val welcome: Welcome = navBackStackEntry.toRoute()
                        WelcomeScreen(
                            welcome = welcome,
                            onBackPressed = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

// ScreenA doesn't take any arguments
@Serializable
object Home

// ScreenB takes a name
@Serializable
data class Welcome(
    val name: String
)

