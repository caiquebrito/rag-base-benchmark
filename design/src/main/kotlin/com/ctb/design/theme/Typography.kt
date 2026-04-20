package com.ctb.design.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// TODO: Drop SplineSans .ttf/.otf into design/src/main/res/font/ and update:
// val SplineSans = FontFamily(
//     Font(R.font.splinesans_bold, FontWeight.Bold),
//     Font(R.font.splinesans_semibold, FontWeight.SemiBold),
//     Font(R.font.splinesans_regular, FontWeight.Normal),
//     Font(R.font.splinesans_medium, FontWeight.Medium),
// )
private val SplineSans = FontFamily.Default

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = SplineSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = SplineSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = SplineSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SplineSans,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
)
