package com.example.projet_02_contacts.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projet_02_contacts.ui.theme.ContactViewModel
import com.example.projet_02_contacts.ui.theme.EcranAjouter
import com.example.projet_02_contacts.ui.theme.EcranContacts
import com.example.projet_02_contacts.ui.theme.EcranDetails
import com.example.projet_02_contacts.ui.theme.EcranModifier

@Composable
fun MainNav(
    navController: NavHostController = rememberNavController(),
    contViewModel: ContactViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            EcranContacts(
                add = {
                navController.navigate("ecranAjout"){
                    launchSingleTop = true
                }
            },
                details = {
                    navController.navigate("ecranDetail"){
                        launchSingleTop = true
                    }
                },
                contViewModel = contViewModel
                )
        }
        composable("ecranAjout"){
            EcranAjouter(
                create = {
                    navController.navigate("home"){
                        launchSingleTop = true
                    }
                },
                back = {
                    navController.navigate("home"){
                        launchSingleTop = true
                    }
                }
                ,
                contViewModel = contViewModel
            )
        }
        composable("ecranModifier"){
            EcranModifier(
                create = {
                    navController.navigate("home"){
                        launchSingleTop = true
                    }
                },
                back = {
                    navController.navigate("ecranDetail"){
                        launchSingleTop = true
                    }
                },
                contViewModel = contViewModel
            )
        }
        composable("ecranDetail"){
            EcranDetails(
                delete = {
                    navController.navigate("home"){
                        launchSingleTop = true
                    }
                },
                update = {
                    navController.navigate("ecranModifier"){
                        launchSingleTop = true
                    }
                },
                back = {
                    navController.navigate("home"){
                        launchSingleTop = true
                    }
                }
                , contViewModel = contViewModel
            )
        }
    }
}