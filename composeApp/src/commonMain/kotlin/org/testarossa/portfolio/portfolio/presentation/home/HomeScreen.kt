package org.testarossa.portfolio.portfolio.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.im
import myportfolio.composeapp.generated.resources.my_full_name
import myportfolio.composeapp.generated.resources.my_name
import org.jetbrains.compose.resources.stringResource
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.utils.isCompactWidth

@Composable
fun HomeScreenRoot(

){

    Box(modifier = Modifier.fillMaxSize()){
        AsyncImage(
            model = Res.getUri("drawable/img_home.webp"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.padding(MediumPadding).align(
                if (isCompactWidth()) Alignment.BottomStart else Alignment.CenterStart
            ),
            verticalArrangement = Arrangement.spacedBy(MediumPadding)
        ) {
            Text(
                text = stringResource(Res.string.my_full_name),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = stringResource(Res.string.im),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}