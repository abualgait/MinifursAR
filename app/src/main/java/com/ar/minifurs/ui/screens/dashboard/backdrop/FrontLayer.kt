package com.ar.minifurs.ui.screens.dashboard.backdrop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ar.minifurs.R
import com.ar.minifurs.data.Product
import com.ar.minifurs.data.products
import com.ar.minifurs.data.productsCategories


@Composable
fun FrontLayer(
    onClick: (Product) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(
                    shape = RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp),
                    color = MaterialTheme.colors.background
                )
        ) {
            item {
                Spacer(modifier = Modifier.height(5.dp))
                LazyRow {
                    items(productsCategories) {
                        ItemCategory(it) {

                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Latest Release",
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(Modifier.weight(1f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "See all",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFE29547),
                                textAlign = TextAlign.Right,
                                letterSpacing = 0.06.sp,
                            )
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowRightAlt,
                            contentDescription = "",
                            tint = Color(0xFFE29547)
                        )
                    }

                }

            }


            itemsIndexed(products.windowed(2, 2, true)) { _, sublist ->
                Row(Modifier.fillMaxWidth()) {
                    sublist.forEach { item ->
                        GridItem(
                            Modifier
                                .fillParentMaxWidth(.5f), item, onClick = onClick
                        )
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(15.dp))
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(
                                        Color(0xFFEFE5D5),
                                        Color(0xFFF2F0E0)
                                    )
                                )
                            )
                            .padding(20.dp)
                    ) {
                        Column {

                            Text(
                                text = "Virtual Reality Showroom",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFE68314),
                                )
                            )
                            Text(
                                text = "Allows you to view our showrooms containing our\nlatest furniture collections",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFE29547),
                                )
                            )
                            Text(
                                text = "Coming Soon...",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF284F49),
                                )
                            )

                        }
                        Image(
                            painter = painterResource(id = R.drawable.vr_device),
                            contentDescription = "", modifier = Modifier
                                .width(140.dp)
                                .height(83.dp)
                        )
                    }
                }
            }

        }

    }
}


@Composable
fun GridItem(modifier: Modifier, item: Product, onClick: (Product) -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .clickable {
                onClick(item)
            },
    ) {

        Box {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.White)
                )
            }
            Column(modifier = Modifier.padding(7.dp)) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = item.title, color = Color(0xFFAAAAAA))
                Text(
                    text = item.price.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF121212),
                        letterSpacing = 0.07.sp
                    )
                )
            }
        }


    }
}

@Composable
fun ItemCategory(it: Product, onClick: (Product) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
        onClick(it)
    }) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (it.id == 0) Color(0xFFE68314) else Color(0xFDDBDBDB)
                )
        ) {
            Image(
                painter = painterResource(id = it.image),
                "",
                modifier = Modifier
                    .size(45.dp)
                    .padding(9.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = it.title,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                letterSpacing = 0.04.sp,
            )
        )
    }
}

