package com.lazanomentsoarabesandratana.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lazanomentsoarabesandratana.movieapp.model.Movie
import com.lazanomentsoarabesandratana.movieapp.model.getMovie
import com.lazanomentsoarabesandratana.movieapp.navigation.MovieScreens
import com.lazanomentsoarabesandratana.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(navController: NavController = rememberNavController()){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.White
                ),
                title = {
                    Text("Movies")
                })
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovie()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {

                MovieRow(movie = it) { movie ->
                    Log.d("TAG", "Movie $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                }
            }
        }
    }

}
