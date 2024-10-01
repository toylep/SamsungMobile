package ru.toylep.samsungmobile.utils.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val cardTextModifier = Modifier
    .padding(4.dp, 0.dp, 0.dp, 0.dp)

@Composable fun BigHeader(text: String) = Text(text = text, fontSize = 28.sp)

@Composable fun FormText(text: String, fontSize: Int = 16) = Text(
    text = text, fontSize = fontSize.sp, modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
)


@Composable fun SquaredButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit,
    border: BorderStroke? = null,
    content: @Composable() RowScope.() -> Unit,
) = Button(
    border = border,
    modifier = modifier,
    colors = colors,
    onClick = onClick,
    shape = RoundedCornerShape(2.dp),
    content= content
)