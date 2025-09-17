package org.testarossa.portfolio.portfolio.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.GetApp
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.ui.graphics.vector.ImageVector

data class Badge(
    val icon: ImageVector,
    val title: String,
    val content: String,
)

val badges = listOf(
    Badge(icon = Icons.Default.Code, title = "total_projects", content = "project_complete"),
    Badge(icon = Icons.Default.GetApp, title = "my_download", content = "downloads"),
    Badge(icon = Icons.Default.WorkspacePremium, title = "total_years", content = "years_experience"),
)