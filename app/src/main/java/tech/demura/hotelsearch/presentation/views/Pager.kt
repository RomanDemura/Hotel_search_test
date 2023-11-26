package tech.demura.hotelsearch.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.SubcomposeAsyncImage
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(urls: List<String>) {
    val pagerState = rememberPagerState { urls.size }

    Box() {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            pageSpacing = 16.dp,
        ) { page ->
            val modifier = Modifier
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
            PagerCard(urls[page], modifier)
        }
        PagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun PagerCard(
    url: String,
    modifier: Modifier
) {
    Card {
        SubcomposeAsyncImage(
            modifier = modifier
                .fillMaxSize(),
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                CircularProgressIndicator()
            },
            error = {
                Icon(Icons.Filled.Lock, contentDescription = null)
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(pagerState: PagerState, modifier: Modifier) {
    Card(
        modifier = modifier.padding(bottom = 8.dp)
    ) {
        Row(
            modifier = modifier
                .wrapContentHeight()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}