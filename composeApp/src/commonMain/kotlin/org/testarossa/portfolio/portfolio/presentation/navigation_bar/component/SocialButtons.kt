package org.testarossa.portfolio.portfolio.presentation.navigation_bar.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.testarossa.portfolio.core.presentation.utils.LocalImage
import org.testarossa.portfolio.portfolio.domain.SocialContacts

@Composable
 fun SocialButtons(
    modifier: Modifier = Modifier,
){
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialContacts.entries.forEach { contact ->
            SocialButton(
                onClick = {
                    uriHandler.openUri(contact.link)
                },
                resource = contact.thumb
            )
        }
    }
}

@Composable
private fun SocialButton(
    onClick: () -> Unit,
    resource: String,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        LocalImage(
            modifier = Modifier.size(28.dp).clip(CircleShape),
            path = resource,
            colorFilter = ColorFilter.tint( MaterialTheme.colorScheme.primary)
        )

    }
}