package org.testarossa.portfolio.portfolio.presentation.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.LargePadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.core.presentation.theme.SmallPadding
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.Language
import org.testarossa.portfolio.portfolio.presentation.setting.component.DarkModeSwitch
import org.testarossa.portfolio.portfolio.presentation.setting.component.LanguageBottomSheetDialog

@Composable
fun SettingScreenRoot(
    isDarkMode: Boolean,
    language: Language,
    onDarkModeChange: (Boolean) -> Unit,
    onLanguageChange: (Language) -> Unit,
) {
    val localString = rememberStrings()

    var showLanguageDialog by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = LargePadding)
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.surfaceContainerHighest,
                    MaterialTheme.shapes.medium
                )
                .padding(bottom = SmallPadding),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surfaceContainer,
                        MaterialTheme.shapes.small
                    )
                    .padding(MediumPadding),
            ) {
                Text(
                    text = localString.get("theme_mode"),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterStart)
                )

                DarkModeSwitch(
                    modifier = Modifier.width(45.dp).align(Alignment.CenterEnd),
                    isChecked = isDarkMode,
                    onCheckedChange = onDarkModeChange
                )
            }
        }
        Spacer(modifier = Modifier.height(LargePadding))
        Box(
            modifier = Modifier
                .padding(horizontal = LargePadding)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(
                    MaterialTheme.colorScheme.surfaceContainerHighest,
                )
                .padding(bottom = SmallPadding),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surfaceContainer,
                        MaterialTheme.shapes.small
                    )
                    .clickable(
                        onClick = {
                            showLanguageDialog = true
                        }
                    )
                    .padding(MediumPadding),
            ) {
                Text(
                    text = localString.get("language"),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterStart)
                )

                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(NormalPadding)
                ) {
                    Text(
                        text = language.displayName,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }

    if (showLanguageDialog) {
        LanguageBottomSheetDialog(
            onDismiss = { showLanguageDialog = false },
            onSelectLanguage = { language ->
                showLanguageDialog = false
                onLanguageChange(language)
            }
        )
    }
}