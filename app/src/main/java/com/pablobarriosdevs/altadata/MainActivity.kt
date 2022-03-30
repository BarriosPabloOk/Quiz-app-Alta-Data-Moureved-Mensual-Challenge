package com.pablobarriosdevs.altadata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.pablobarriosdevs.altadata.feature_quiz.presentation.navigation.Navigation
import com.pablobarriosdevs.altadata.ui.theme.AltaDataTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AltaDataTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    val navController = rememberNavController()
                    Navigation(navController = navController)

                }
            }
        }
    }
}

