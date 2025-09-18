package org.testarossa.portfolio.portfolio.presentation.resume.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch
import org.testarossa.portfolio.core.presentation.utils.LocalImage
import org.testarossa.portfolio.portfolio.domain.MyProject

@Composable
fun PreviewDialog(
    project: MyProject,
    onDismiss: () -> Unit
) {
    val coroutine = rememberCoroutineScope()
    Dialog(
        onDismissRequest = onDismiss
    ) {
        val pagerState = rememberPagerState { project.sizeImage }
        Box {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
            ) { page ->
                val currentThumb =
                    remember(project) { project.pathImage.replace("%d", "${page + 1}") }

                LocalImage(
                    modifier = Modifier.fillMaxSize(),
                    path = currentThumb,
                )

            }
            IconButton(
                modifier = Modifier.align(Alignment.CenterStart),
                enabled = pagerState.currentPage > 0,
                onClick = {
                        coroutine.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.38f),
                )
            ) {
                Icon(
                    Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                enabled = pagerState.currentPage < pagerState.pageCount - 1,
                onClick = {
                        coroutine.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }

                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.38f),
                )
            ) {
                Icon(
                    Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}