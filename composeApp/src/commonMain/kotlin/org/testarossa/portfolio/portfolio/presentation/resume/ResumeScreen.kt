package org.testarossa.portfolio.portfolio.presentation.resume

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.LargePadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.portfolio.domain.MY_PROJECTS
import org.testarossa.portfolio.portfolio.domain.MyProject
import org.testarossa.portfolio.portfolio.presentation.resume.component.PreviewDialog
import org.testarossa.portfolio.portfolio.presentation.resume.component.ProjectItem

@Composable
fun ResumeScreenRoot() {

    val localString = rememberStrings()
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthSizeClass = windowSizeClass.windowWidthSizeClass

    val column = when (widthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 1
        WindowWidthSizeClass.MEDIUM -> 2
        else -> 3
    }

    var projects by remember {
        mutableStateOf(MY_PROJECTS.take(3))
    }

    var preview: MyProject? by remember {
        mutableStateOf(null)
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
                text = localString.get("featured_projects"),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = LargePadding)
            )
        }
        item(span = { GridItemSpan(this.maxLineSpan) }) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = localString.get("featured_project_describe"),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(top = NormalPadding, bottom = MediumPadding)
                        .widthIn(max = 720.dp).fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        items(projects, key = { it.title }) { project ->
            ProjectItem(
                modifier = Modifier.fillMaxWidth(),
                project = project,
                onViewProject = {
                    preview = project
                }
            )
        }

        if (projects.size < MY_PROJECTS.size) {
            item(span = { GridItemSpan(this.maxLineSpan) }) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    TextButton(
                        onClick = {
                            projects = MY_PROJECTS
                        },
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSurface.copy(0.8f)
                        ),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(
                            text = localString.get("view_all_projects"),
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }


    preview?.let { proj ->
        PreviewDialog(
            project = proj,
            onDismiss = { preview = null }
        )
    }
}