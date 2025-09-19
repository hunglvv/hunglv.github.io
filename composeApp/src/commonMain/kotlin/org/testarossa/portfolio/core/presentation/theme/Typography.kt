package org.testarossa.portfolio.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.dancingscript_bold
import myportfolio.composeapp.generated.resources.inter_400
import myportfolio.composeapp.generated.resources.inter_500
import myportfolio.composeapp.generated.resources.inter_700
import myportfolio.composeapp.generated.resources.inter_900
import org.jetbrains.compose.resources.Font

val Inter @Composable get() = FontFamily(
    Font(
        resource = Res.font.inter_400,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.inter_500,
        weight = FontWeight.Medium
    ),

    Font(
        resource = Res.font.inter_700,
        weight = FontWeight.Bold
    ),
    Font(
        resource = Res.font.inter_900,
        weight = FontWeight.Black
    ),
)

val SpecialFont @Composable get() = FontFamily(
    Font(
        resource = Res.font.dancingscript_bold,
        weight = FontWeight.Bold
    )
)

val baseline = Typography()
val Typography: Typography @Composable get() = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = Inter),
    displayMedium = baseline.displayMedium.copy(fontFamily = SpecialFont),    //
    displaySmall = baseline.displaySmall.copy(fontFamily = Inter),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = SpecialFont), //
    headlineMedium = baseline.headlineMedium.copy(fontFamily = Inter),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = Inter),
    titleLarge = baseline.titleLarge.copy(fontFamily = Inter),
    titleMedium = baseline.titleMedium.copy(fontFamily = Inter),
    titleSmall = baseline.titleSmall.copy(fontFamily = Inter),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = Inter),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = Inter),
    bodySmall = baseline.bodySmall.copy(fontFamily = Inter),
    labelLarge = baseline.labelLarge.copy(fontFamily = Inter),
    labelMedium = baseline.labelMedium.copy(fontFamily = Inter),
    labelSmall = baseline.labelSmall.copy(fontFamily = Inter),
)