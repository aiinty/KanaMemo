package com.aiinty.kanamemo.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aiinty.kanamemo.R

@Composable
fun NavigationBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    NavigationBar (
        modifier = modifier
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = ImageVector.vectorResource(navItem.imageId),
                        contentDescription = navItem.title)
                },
                label = {
                    Text(navItem.title)
                }
            )
        }
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Text",
            imageId = R.drawable.notes,
            route = Destination.TEXT
        ),
        BarItem(
            title = "Mora",
            imageId = R.drawable.language_japanese_kana,
            route = Destination.MORA
        )
    )
}

data class BarItem(
    val title: String,
    val imageId: Int,
    val route: String
)