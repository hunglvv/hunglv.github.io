package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about
import myportfolio.composeapp.generated.resources.home
import myportfolio.composeapp.generated.resources.resume
import myportfolio.composeapp.generated.resources.settings
import myportfolio.composeapp.generated.resources.skill
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.testarossa.portfolio.app.Route

enum class SocialContacts(
    val thumb: String,
    val link: String,
) {
    FACEBOOK(
        thumb = "drawable/img_facebook.webp",
        link = "https://www.facebook.com/hung.le.524334"
    ),
    TELEGRAM(
        thumb = "drawable/img_telegram.webp",
        link = "https://t.me/nashishi"
    ),
    DISCORD(
        thumb = "drawable/img_discord.webp",
        link = "https://discord.com/users/369725636954292227"
    ),
    GITHUB(
        thumb = "drawable/img_github.webp",
        link = "https://github.com/hunglvv"
    )
}