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
fun RankingButton(
    onClick: ()->Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        contentPadding = PaddingValues(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.error,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Ranking",
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.typography.body2.fontSize,
            textAlign = TextAlign.Center,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PrevRankingButton() {
    RankingButton(
        onClick = {},
        modifier = Modifier.width(120.dp)
    )
}