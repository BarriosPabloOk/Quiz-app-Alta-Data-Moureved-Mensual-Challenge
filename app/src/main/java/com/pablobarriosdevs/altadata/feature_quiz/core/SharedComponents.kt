package com.pablobarriosdevs.altadata.feature_quiz.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablobarriosdevs.altadata.R

//Backgrounds
@Composable
fun MainBackground(
    alpha: Float = 1f
) {
    Image(
        painter = painterResource(id = R.mipmap.background_4),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        alpha = alpha
    )
}

@Composable
fun AlternativeBackground(
    alpha: Float = 1f
) {
    Image(
        painter = painterResource(id = R.mipmap.background_3),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        alpha = alpha
    )
}


//Card

@Composable
fun CustomCard(
    Content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(
                    MaterialTheme.colors.surface
                )
                .padding(20.dp,)

        ) {
            Content()
        }

    }
}

//buttons
@Composable
fun StartEndButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        contentPadding = PaddingValues(vertical = 15.dp, horizontal = 17.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp


        )
    }

}















