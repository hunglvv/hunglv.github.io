package org.testarossa.portfolio.portfolio.presentation.skill.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults.drawStopIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.progress
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.testarossa.portfolio.core.presentation.theme.ExpandPadding
import org.testarossa.portfolio.core.presentation.theme.LargePadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.core.presentation.theme.SmallPadding
import org.testarossa.portfolio.portfolio.domain.MySkill

@Composable
fun SkillItem(
    modifier: Modifier = Modifier,
    skill: MySkill
) {
    Column(
        modifier = modifier.background(
            MaterialTheme.colorScheme.surfaceContainer,
            MaterialTheme.shapes.medium
        )
            .padding(LargePadding),
        verticalArrangement = Arrangement.spacedBy(MediumPadding)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(NormalPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                skill.icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = stringResource(skill.title),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
        skill.listSkill.forEach { skill ->
            SkillDetail(
                modifier = Modifier.padding(top = NormalPadding).fillMaxWidth(),
                name = skill.first,
                percent = skill.second
            )
        }
    }
}

@Composable
fun SkillDetail(
    modifier: Modifier = Modifier,
    name: StringResource,
    percent: Int
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(SmallPadding)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(name),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = stringResource(Res.string.progress, percent),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth().height(NormalPadding),
            progress = { percent / 100f },
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            strokeCap = StrokeCap.Round,
            gapSize = -NormalPadding,
            drawStopIndicator = { }
        )
    }
}