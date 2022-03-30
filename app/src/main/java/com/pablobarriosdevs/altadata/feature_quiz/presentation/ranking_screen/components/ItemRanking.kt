package com.pablobarriosdevs.altadata.feature_quiz.presentation.ranking_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pablobarriosdevs.altadata.ui.theme.AltaDataTheme

@Composable
fun ItemRanking(
    name: String,
    score: Int
) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.typography.h6.fontSize
            )
            Text(
                text = "$score",
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.typography.h6.fontSize
            )


        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.DarkGray
        )

    }



}

@Preview(showSystemUi = true)
@Composable
fun PrevListItem() {
    AltaDataTheme {
        ItemRanking(name = "pablo", score = 500)
    }
}