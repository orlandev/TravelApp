package com.orlandev.travelapp.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.orlandev.travelapp.data.Activities
import com.orlandev.travelapp.ui.screens.home.ImageBanner
import com.orlandev.travelapp.ui.theme.containerColor
import com.orlandev.travelapp.ui.theme.starColors
import com.orlandev.travelapp.utils.horizontalPadding


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel(),

    ) {

    val currentDestination = detailViewModel.currentCityData.value//Only for now

    currentDestination?.let {
        Scaffold(modifier = Modifier.fillMaxSize()) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(4 / 3f)
                    ) {

                        //Image

                        ImageBanner(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(4f / 3f)
                                .padding(horizontal = 12.dp), someDestination = currentDestination
                        )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = horizontalPadding)
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                        }

                        Row {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                            }
                        }
                    }
                }
            }

            items(currentDestination.listOfActivities) { currentActivity ->
                ActivityCard(currentActivity)
            }
        }
    }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ActivityCard(currentActivity: Activities) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = horizontalPadding)
    ) {

        androidx.compose.material.Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .padding(start = 20.dp), elevation = 10.dp, shape = RoundedCornerShape(12.dp),
            onClick = { /*TODO*/ }) {
        }

        //TODO ADD SHIMMER EFFECT
        Row(modifier = Modifier.fillMaxSize()) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(108.dp)
                    .padding(vertical = 15.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
                model = currentActivity.imageUrl, contentDescription = null,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(15.dp))
                            .placeholder(
                                true,
                                color = Color.Gray,
                                highlight = PlaceholderHighlight.shimmer(
                                    highlightColor = Color.White,
                                )
                            )
                    )
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .padding(vertical = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp)
                            .weight(1.4f),
                        text = currentActivity.name,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        fontSize = 18.sp,
                    )
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "$${currentActivity.price}",
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.End
                        )
                        Text(
                            text = "por pax",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                            textAlign = TextAlign.End
                        )
                    }
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = currentActivity.type,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                        textAlign = TextAlign.Start
                    )

                    Stars()

                    Row(modifier = Modifier.fillMaxWidth()) {
                        currentActivity.startTimes.forEach { currentTime ->
                            BoxText(currentTime)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun BoxText(currentTime: String) {

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(containerColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = currentTime,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun Stars() {

    val starIcon = Icons.Rounded.Star

    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        for (i in 1..5) {
            Icon(
                modifier = Modifier.size(9.dp),
                imageVector = starIcon,
                contentDescription = null,
                tint = starColors
            )
        }
    }

}
