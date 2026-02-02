package com.lazanomentsoarabesandratana.movieapp.screens.details

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.lazanomentsoarabesandratana.movieapp.R
import com.lazanomentsoarabesandratana.movieapp.model.Movie
import com.lazanomentsoarabesandratana.movieapp.model.getMovie
import com.lazanomentsoarabesandratana.movieapp.widgets.MovieRow


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailsScreen(navController: NavController= rememberNavController(), movieId: String?= null){
    val movie = getMovie().filter { movie -> movie.id == movieId
    }[0]
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
        MainDetaisScreen(navController = navController, modifier = Modifier.padding(paddingValues), movie = movie)
    }

}

@Preview(showBackground = true)
@Composable
fun MainDetaisScreen(navController: NavController = rememberNavController(), modifier: Modifier = Modifier, movie: Movie? = null){
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        MovieRow (movie = movie!!)
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        horizontalScrollableImageView(movie)

        /*Text("Movie data ${movie?.title}",
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(23.dp))
        Button(onClick = {
            Log.d("TAG", "Click button back")
            navController.popBackStack()
        }) {
            Text(text = "Go Back")
        }*/
    }
}

@Composable
private fun horizontalScrollableImageView(movie: Movie) {
    LazyRow {
        items(movie.images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = image,
                    contentDescription = "Movie poster",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    error = painterResource(R.drawable.ic_launcher_foreground),
                    onError = { error ->
                        // Log the error cause to Logcat
                        Log.d("Error", " error: ${error.result.throwable.message}")
                    }
                )
            }
        }
    }
}