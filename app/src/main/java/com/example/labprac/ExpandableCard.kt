package com.example.labprac

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.Icon
import com.example.labprac.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = 20.sp,
    titleFontWeight: FontWeight = FontWeight.Bold,
    discription: String,
    discriptionFontSize: TextUnit = 12.sp,
    discriptionFontWeight: FontWeight = FontWeight.Normal,
    discriptionMaxLines: Int = 4,
    shape: CornerBasedShape = Shapes.medium,
    padding: Dp = 12.dp
) {
    var expandableState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandableState) 180f else 0f,
        label = "Rotation State"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandableState = !expandableState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandableState = !expandableState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandableState) {
                Text(
                    text = discription,
                    fontSize = discriptionFontSize,
                    fontWeight = discriptionFontWeight,
                    maxLines = discriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(
        title = "My Title",
        discription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. " +
                "Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. " +
                "Praesent mauris. Fusce nec tellus sed augue semper porta. " +
                "Mauris massa. Vestibulum lacinia arcu eget nulla. " +
                "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. " +
                "Curabitur sodales ligula in libero. " +
                "Sed dignissim lacinia nunc. \n"
    )
}