package com.example.labprac

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun SuperScriptText(
    normalText: String,
    normalFontSize: TextUnit = 16.sp,
    superText: String,
    superFontSize: TextUnit = 10.sp,
    superTextFontWeight: FontWeight = FontWeight.Normal
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
           buildAnnotatedString {
               withStyle(
                   style = SpanStyle(
                       fontSize = normalFontSize
                   )
               ){
                   append(normalText)
               }
               withStyle(
                   style = SpanStyle(
                       fontSize = superFontSize,
                       fontWeight = superTextFontWeight,
                       baselineShift = BaselineShift.Superscript
                   )
               ){
                   append(superText)
               }
           }
        )
    }
}