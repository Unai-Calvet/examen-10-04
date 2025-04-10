package cat.itb.m78.exercices

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.llistaEstudiants.LlistaEstudiantsScreen
import cat.itb.m78.exercices.llistaFaltes.LlistaFaltesScreen

@Composable
fun NavController() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    NavigationBarItem(
                        onClick = { navController.navigate(Destination.LlistaEstudiantsScreen) },
                        icon = {
                            Icon(
                                Icons.Filled.Face, contentDescription = "Alumnes"
                            )
                        },
                        selected = false
                    )
                    NavigationBarItem(
                        onClick = { navController.navigate(Destination.LlistaFaltesScreen) },
                        icon = {
                            Icon(
                                Icons.Filled.Close,
                                contentDescription = "Faltes"
                            )
                        },
                        selected = false
                    )
                }
            )
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = Destination.LlistaEstudiantsScreen
        ) {
            composable<Destination.LlistaEstudiantsScreen> {
                LlistaEstudiantsScreen()
            }
            composable<Destination.LlistaFaltesScreen> {
                LlistaFaltesScreen()
            }
        }
    }
}
