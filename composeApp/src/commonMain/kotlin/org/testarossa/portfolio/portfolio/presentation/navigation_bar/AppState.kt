package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.runtime.Immutable
import org.testarossa.portfolio.app.Route

@Immutable
data class AppState(
    val currentRoute: Route? = null,
    val isDarkMode: Boolean = false,
    val currentLanguage: Language = Language.EN,
)


enum class Language(
    val code: String,
    val displayName: String
) {
    EN("en", "English"),
    VI("vn", "Tiếng Việt")
}
