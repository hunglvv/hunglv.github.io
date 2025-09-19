package org.testarossa.portfolio.portfolio.presentation.about.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.core.presentation.theme.SmallPadding

private val MY_TECHNOLOGIES = listOf(
    "Kotlin",
    "Java",
    "Android SDK",
    "Jetpack Compose",
    "MVVM",
    "Room Database",
    "Retrofit",
    "Coil",
    "Coroutines",
    "Flow",
    "Dagger Hilt",
    "Work Manager",
    "Data Store",
    "Firebase",
    "Material Design",
    "Git",
    "CI/CD",
    "Unit Test",
    "..."
)

@Composable
fun MyTechnologies(
    modifier: Modifier = Modifier,
) {
    val localString = rememberStrings()
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MediumPadding)
    ) {
        Text(
            text = localString.get("technologies"),
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colorScheme.onSurface
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(NormalPadding),
            verticalArrangement = Arrangement.spacedBy(NormalPadding)
        ) {
            MY_TECHNOLOGIES.forEach { tech ->
                Text(
                    text = tech,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.surfaceContainer,
                        MaterialTheme.shapes.medium
                    ).padding(vertical = SmallPadding, horizontal = NormalPadding)
                )
            }
        }
    }
}