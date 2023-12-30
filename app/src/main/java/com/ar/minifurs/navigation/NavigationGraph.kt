package com.ar.minifurs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ar.minifurs.data.Product
import com.ar.minifurs.ui.screens.ARView
import com.ar.minifurs.ui.screens.ProductDetails
import com.ar.minifurs.ui.screens.dashboard.DashboardScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController,
        startDestination = BottomNavigationRoute.BottomNavigation.value,
        route = Route.MainActivity.value
    ) {

        bottomNavigationGraph(navController)
        composable(
            Route.ProductDetails.value,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            ProductDetails(it.arguments?.getInt("id"), navController) { product ->
                navController.gotoARView(product)
            }
        }

        composable(
            Route.ARView.value,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            ARView(it.arguments?.getInt("id"), navController) {

            }
        }


    }
}


fun NavGraphBuilder.bottomNavigationGraph(navController: NavHostController) {
    navigation(
        startDestination = BottomNavItem.Dashboard.screenRoute,
        route = BottomNavigationRoute.BottomNavigation.value
    ) {
        composable(BottomNavItem.Dashboard.screenRoute) {
            DashboardScreen {
                navController.gotoProductDetails(it)
            }
        }

        composable(BottomNavItem.Cart.screenRoute) {
            DashboardScreen {
                navController.gotoProductDetails(it)
            }
        }

        composable(BottomNavItem.Favorites.screenRoute) {
            DashboardScreen {
                navController.gotoProductDetails(it)
            }
        }

        composable(BottomNavItem.Profile.screenRoute) {
            DashboardScreen {
                navController.gotoProductDetails(it)
            }
        }

    }
}

fun NavHostController.gotoARView(product: Product) {
    navigate("ArView/${product.id}")
}

fun NavHostController.gotoProductDetails(product: Product) {
    navigate("ProductDetails/${product.id}")
}