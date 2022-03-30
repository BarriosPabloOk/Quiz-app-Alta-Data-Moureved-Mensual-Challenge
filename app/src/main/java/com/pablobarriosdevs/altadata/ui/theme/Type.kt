package com.pablobarriosdevs.altadata.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pablobarriosdevs.altadata.R

// Set of Material typography styles to start with

val badaboom = FontFamily(
    Font(R.font.badaboom)
)
val toonTime = FontFamily(
    Font(R.font.toontime, FontWeight.Normal),
    Font(R.font.toontime_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.toontime_bold, FontWeight.Bold),
    Font(R.font.toontime_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.toontime_blotch, FontWeight.Light),
    Font(R.font.toontime_blotch_italic, FontWeight.Light, FontStyle.Italic)
)

//toontime
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 97.sp
    ),
    h2 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 60.sp
    ),
    h3 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp
    ),
    h4 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,

    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

//badaboom
val BadabomTypography = Typography(
    h1 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 97.sp
    ),
    h2 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 60.sp
    ),
    h3 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp
    ),
    h4 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = toonTime,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
)