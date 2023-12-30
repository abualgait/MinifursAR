package com.ar.minifurs.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ar.minifurs.R
import com.ar.minifurs.data.Product
import com.ar.minifurs.data.products
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductDetails(
    productId: Int?,
    navController: NavHostController,
    onClick: (Product) -> Unit = {}
) {
    val product = products.find {
        it.id == productId
    }

    Box(modifier = Modifier.fillMaxSize()) {
        product?.let { product ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                stickyHeader {
                    Pager(product)
                }

                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                text = product.title,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF121212),
                                    letterSpacing = 0.1.sp,
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = product.price.toString(),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFFE29547),
                                    letterSpacing = 0.1.sp,
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row {
                                repeat(3) {
                                    Box(
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .background(getRandomColor(), CircleShape)
                                            .size(24.dp)
                                    )
                                }
                            }

                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xFFE0E0E0))
                                    .padding(10.dp)
                            ) {
                                Icon(Icons.Filled.BookmarkBorder, contentDescription = "")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_minus),
                                    contentDescription = null
                                )
                                Text(
                                    text = "1",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF121212),
                                        textAlign = TextAlign.Center,
                                        letterSpacing = 0.06.sp,
                                    ), modifier = Modifier.padding(horizontal = 16.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.icon_plus),
                                    contentDescription = null
                                )

                            }

                        }
                    }
                }
                item {

                    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFFFFEEDD))
                                .padding(12.dp)

                        ) {
                            Text(
                                text = "Description",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFFE29547),
                                    letterSpacing = 0.07.sp,
                                )
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color.Transparent)
                                .padding(12.dp)

                        ) {
                            Text(
                                text = "Reviews",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFFAAAAAA),
                                    letterSpacing = 0.07.sp,
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc consectetur velit at massa vehicula, quis fringilla urna gravida. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc consectetur velit at massa vehicula, quis fringilla urna gravida. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc consectetur velit at massa vehicula, quis fringilla urna gravida. ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFAAAAAA),
                            letterSpacing = 0.07.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Delivery: 15 days after payment confirmation",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFE68314),
                            letterSpacing = 0.07.sp,
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Delivery: 15 days after payment confirmation",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFE68314),
                            letterSpacing = 0.07.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(70.dp))
                }

            }
        }

        Box(modifier = Modifier.padding(top = 30.dp, start = 20.dp)) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFF252525))
                    .padding(10.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = ""
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(10.dp), horizontalArrangement = Arrangement.spacedBy(
                16.dp,
                Alignment.CenterHorizontally
            )

        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFF828282),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .weight(0.20f)
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_view_in_ar_new_googblue_48dp),
                    contentDescription = "image description",
                    modifier = Modifier
                        .alpha(0f)
                        .size(24.dp)
                )
                Text(
                    text = "Add to cart",
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.05.sp,
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(0.60f)
                    .background(
                        color = Color(0xFF284F49),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(start = 10.dp, top = 10.dp, end = 18.dp, bottom = 10.dp)
                    .clickable {
                        product?.let { onClick(it) }
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_view_in_ar_new_googblue_48dp),
                    contentDescription = "image description",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "View in your space",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.06.sp,
                        color = Color.White
                    )
                )
            }


        }

    }


}

fun getRandomColor(): Color {
    val random = Random
    return Color(
        red = random.nextFloat(),
        green = random.nextFloat(),
        blue = random.nextFloat(),
        alpha = 1f
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(product: Product) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
    ) {
        val pageCount = 3
        val pagerState = rememberPagerState(
            pageCount = { pageCount },
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painterResource(id = R.drawable.imagebg),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )

                Image(
                    painterResource(id = R.drawable.chair_pager),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )
            }

        }
        Row(
            Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color, CircleShape)
                        .size(5.dp)
                )
            }
        }
    }
}