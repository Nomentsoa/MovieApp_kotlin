package com.lazanomentsoarabesandratana.movieapp.screens.details

import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailsScreen(navController: NavController= rememberNavController(), movieData: String?= null){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.White
                ),

                title = {
                    Text("Movies")
                },
                navigationIcon = {
                    if(navController.previousBackStackEntry != null){
                        IconButton(colors = IconButtonColors(
                            containerColor = Color.Magenta,
                            contentColor = Color.White,
                            disabledContainerColor = Color.Magenta,
                            disabledContentColor = Color.Black,
                        ), onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                })

        }
    ) {
        paddingValues ->
        MainDetaisScreen(navController = navController, modifier = Modifier.padding(paddingValues), movieData = movieData)
    }

}

@Preview(showBackground = true)
@Composable
fun MainDetaisScreen(navController: NavController = rememberNavController(), modifier: Modifier = Modifier, movieData: String? = null){
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Movie data $movieData",
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(23.dp))
        Button(onClick = {
            Log.d("TAG", "Click button back")
            navController.popBackStack()
        }) {
            Text(text = "Go Back")
        }
    }
}