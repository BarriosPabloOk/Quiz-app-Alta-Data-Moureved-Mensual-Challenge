package com.pablobarriosdevs.altadata.feature_quiz.presentation.screen_home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StartButton(
    onClick: ()->Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "EMPEZAR A JUGAR",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.body2.fontSize,
            textAlign = TextAlign.Center,
        )
    }

}

@Preview
@Composable
fun PrevStartButton() {
    StartButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.width(210.dp)
    )
}