package com.example.labprac

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.example.labprac.ui.theme.color1
import com.example.labprac.ui.theme.color2

@Composable
fun GradientButton(
    text: String = "Button",
    textColor: Color = Color.White,
    gradient: Brush = Brush.horizontalGradient(
            colors = listOf(
                color1,
                color2
            ),
    ),
    onClick: () -> Unit,
    navController: NavController
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                // Corrected comment below
                .wrapContentWidth(Alignment.CenterHorizontally), // Adjusts the width according to the content
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}
