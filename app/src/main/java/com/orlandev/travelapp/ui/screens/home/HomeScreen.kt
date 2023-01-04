package com.orlandev.travelapp.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.orlandev.travelapp.R
import com.orlandev.travelapp.data.Destination
import com.orlandev.travelapp.navigation.NavRoute
import com.orlandev.travelapp.ui.theme.containerColor
import com.orlandev.travelapp.ui.theme.primaryColor
import com.orlandev.travelapp.ui.theme.textWhiteColor
import com.orlandev.travelapp.utils.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel(), navController: NavHostController) {

    val dataList = homeViewModel.dataResult.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {

            //IN A REAL APP YOU SHOULD USE A BOTTOM NAVIGATION BAR

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = primaryColor
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Explore,
                        contentDescription = null,
                        tint = Color.Gray.copy(
                            iconGrayColorAlpha
                        )
                    )
                }

                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape)
                        .clickable { }, contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.user), contentDescription = null
                )

            }

        }

    ) { innerPaddings ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddings),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            item {
                Text(
                    modifier = Modifier.padding(horizontal = horizontalPadding),
                    text = stringResource(id = R.string.home_title_text),
                    style = MaterialTheme.typography.displaySmall,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            }

            item {
                //TODO REFACTOR THIS COMPONENT
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalPadding)
                        .horizontalScroll(rememberScrollState(0)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(containerColor)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(iconSize),
                            painter = painterResource(id = R.drawable.ic_airplane_24),
                            contentDescription = "Fly",
                            tint = primaryColor
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray.copy(alpha = containerGrayColorAlpha))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(iconSize),
                            painter = painterResource(id = R.drawable.ic_car_24),
                            contentDescription = "travel",
                            tint = Color.Gray.copy(alpha = iconGrayColorAlpha)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray.copy(alpha = containerGrayColorAlpha))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(iconSize),
                            painter = painterResource(id = R.drawable.ic_beach_24),
                            contentDescription = "Beach",
                            tint = Color.Gray.copy(alpha = iconGrayColorAlpha)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray.copy(alpha = containerGrayColorAlpha))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(iconSize),
                            painter = painterResource(id = R.drawable.ic_hotel_24),
                            contentDescription = "Hotel",
                            tint = Color.Gray.copy(alpha = iconGrayColorAlpha)
                        )
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.size(10.dp))

                    //TODO REFACTOR THIS TO A GENERIC COMPOENENT
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = horizontalPadding),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = stringResource(id = R.string.top_destinations),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        TextButton(onClick = {}) {
                            Text(text = stringResource(id = R.string.see_all), color = primaryColor)
                        }
                    }

                    TravelList(dataList) {
                        navController.navigate(NavRoute.DetailScreenRoute.route + "/${it.city}")
                    }

                }
            }

            item {
                ExclusiveDestination(dataList.random()) {

                    //TODO PERFORM EXCLUSIVE DESTINATION DETAILS

                }
            }

            //LAST ITEM TO PERFORM SOME SPACE IN THE END OF THE LIST
            item {
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun ExclusiveDestination(someDestination: Destination, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.exclusive_destinations),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = {}) {
                Text(text = stringResource(id = R.string.see_all), color = primaryColor)
            }
        }

        ImageBanner(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .padding(horizontal = horizontalPadding)
                .padding(8.dp)
                .clickable { onClick() }, someDestination
        )

    }
}

@Composable
fun ImageBanner(modifier: Modifier = Modifier, someDestination: Destination) {
    androidx.compose.material.Card(
        modifier = modifier,
        elevation = 12.dp,
        shape = RoundedCornerShape(25.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = someDestination.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = someDestination.city
            )

            Gradient()

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            ) {
                Text(
                    text = someDestination.city,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    color = textWhiteColor
                )

                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(10.dp),
                        painter = painterResource(id = R.drawable.gps_arrow_),
                        contentDescription = null,
                        tint = textWhiteColor.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = someDestination.country,
                        color = textWhiteColor.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

@Composable
fun TravelList(dataList: List<Destination>, onClick: (Destination) -> Unit) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item {
            Spacer(modifier = Modifier.size(10.dp))
        }
        items(dataList) { currentDestination ->
            TravelCard(currentDestination) {
                onClick(currentDestination)
            }
        }
        item {
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Composable
fun TravelCard(currentDestination: Destination, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(210.dp)
                .height(280.dp)
        ) {

            androidx.compose.material.Card(
                backgroundColor = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .align(Alignment.BottomCenter),
                elevation = cardElevation,
                shape = RoundedCornerShape(10.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 35.dp)
                        .padding(10.dp)
                ) {

                    Text(
                        text = "${currentDestination.listOfActivities.size} actividades",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 22.sp
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = currentDestination.description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Gray
                    )
                }
            }

            //Image
            androidx.compose.material.Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp)
                    .align(Alignment.TopCenter), shape = RoundedCornerShape(20.dp),
                elevation = cardElevation
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        model = currentDestination.imageUrl, contentDescription = null
                    )

                    Gradient()

                    //TODO REFACTOR THIS AS A COMPONENT
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = currentDestination.city,
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 22.sp, fontWeight = FontWeight.Bold,
                            color = textWhiteColor
                        )

                        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                modifier = Modifier.size(10.dp),
                                painter = painterResource(id = R.drawable.gps_arrow_),
                                contentDescription = null,
                                tint = textWhiteColor.copy(alpha = 0.7f)
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(
                                text = currentDestination.country,
                                color = textWhiteColor.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Gradient() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        Pair(0.40f, Color.Transparent),
                        Pair(1f, Color.Black.copy(alpha = 0.2f))
                    )
                )
            )
    )
}