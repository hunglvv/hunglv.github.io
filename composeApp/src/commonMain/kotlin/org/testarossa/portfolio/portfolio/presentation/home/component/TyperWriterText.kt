package org.testarossa.portfolio.portfolio.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.delay
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.MediumPadding

@Composable
fun TyperWriterText(
    modifier: Modifier = Modifier,
){
    val localString = rememberStrings()
    var isFirstText by remember {
        mutableStateOf(true)
    }

    var textToDisplay by remember { mutableStateOf("") }
    LaunchedEffect(key1 = isFirstText) {
        val text = if (isFirstText) localString.get("im_developer") else localString.get("im_freelancer")
        for (i in text.toCharArray()) {
            textToDisplay = textToDisplay.replace("_","") + i + "_"
            delay(160L)
        }
        repeat(5){
            textToDisplay = textToDisplay.replace("_","") + "_"
            delay(160L)
            textToDisplay = textToDisplay.replace("_","")
            delay(160L)
        }
        textToDisplay = ""
        isFirstText = !isFirstText
    }
    Text(
        text = textToDisplay,
        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
    )
}