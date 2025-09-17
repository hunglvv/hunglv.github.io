package org.testarossa.portfolio.portfolio.presentation.about.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding

private val PROFILE_INFO_KEYS = listOf(
    "birthday", "phone", "age", "degree", "email", "city", "freelance"
)

@Composable
fun MyInfo(
    modifier: Modifier = Modifier
){
    val localString = rememberStrings()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(NormalPadding)
    ){
        PROFILE_INFO_KEYS.forEach { info ->
            RowInfo(
                modifier = Modifier.fillMaxWidth(),
                info = localString.get(info)
            )
        }
    }
}


@Composable
fun RowInfo(
    modifier: Modifier,
    info: String
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MediumPadding)
    ){
        Icon(
            Icons.AutoMirrored.Default.ArrowRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = info,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}