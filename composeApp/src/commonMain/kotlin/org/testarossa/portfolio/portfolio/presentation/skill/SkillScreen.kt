package org.testarossa.portfolio.portfolio.presentation.skill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import org.jetbrains.compose.resources.stringResource
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.ExpandPadding
import org.testarossa.portfolio.core.presentation.theme.LargePadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.portfolio.domain.MY_SKILLS
import org.testarossa.portfolio.portfolio.domain.MY_TOOLS
import org.testarossa.portfolio.portfolio.presentation.skill.component.SkillItem
import org.testarossa.portfolio.portfolio.presentation.skill.component.ToolDetail

@Composable
fun SkillScreenRoot() {
    val localString = rememberStrings()
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthSizeClass = windowSizeClass.windowWidthSizeClass

    val column = when (widthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 1
        WindowWidthSizeClass.MEDIUM -> 4
        else -> 6
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(column),
        modifier = Modifier
            .fillMaxSize()
            .padding(LargePadding),
        contentPadding = PaddingValues(bottom = MediumPadding),
        horizontalArrangement = Arrangement.spacedBy(MediumPadding),
        verticalArrangement = Arrangement.spacedBy(MediumPadding)
    ) {
        item(span = { GridItemSpan(this.maxLineSpan) }) {
            Text(
                text = localString.get("skill_expertise"),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = LargePadding)
            )
        }
        item(span = { GridItemSpan(this.maxLineSpan) }) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = localString.get("skill_overview"),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(top = NormalPadding, bottom = MediumPadding)
                        .widthIn(max = 720.dp).fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(
            MY_SKILLS,
            key = { it.title },
            span = { GridItemSpan(if (column == 1) 1 else this.maxLineSpan / 2) }) { skill ->
            SkillItem(
                modifier = Modifier.fillMaxWidth(),
                skill = skill
            )
        }

        item(span = { GridItemSpan(this.maxLineSpan) }) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = localString.get("tool_tech"),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = ExpandPadding),
                )
            }
        }
        items(MY_TOOLS, key = { it.title }) { tool ->
            ToolDetail(
                modifier = Modifier.fillMaxWidth(),
                icon = tool.icon,
                title = stringResource(tool.title)
            )
        }
    }
}