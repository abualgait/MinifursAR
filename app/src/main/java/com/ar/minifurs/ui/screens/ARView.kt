package com.ar.minifurs.ui.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.ar.minifurs.data.models
import com.ar.minifurs.data.products
import com.google.android.filament.Engine
import com.google.ar.core.Config
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.ar.node.PlacementMode
import kotlinx.coroutines.delay

const val scaleToUnits = 0.8f

@Composable
fun ARView(productId: Int?, navController: NavHostController, onClick: (Product) -> Unit = {}) {

    val product = products.find {
        it.id == productId
    }
    var showInstructions by remember {
        mutableStateOf(true)
    }
    val currentModel = remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        delay(3000)
        showInstructions = false
    }
    Column(modifier = Modifier.fillMaxSize()) {
        product?.let { product ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), contentAlignment = Alignment.Center
            ) {

                ARScreen(currentModel.value)

                Box(modifier = Modifier.fillMaxSize(0.8f)) {
                    Image(
                        painter = painterResource(id = R.drawable.vector_1),
                        contentDescription = "",
                        modifier = Modifier.align(
                            Alignment.TopStart
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vector_2),
                        contentDescription = "",
                        modifier = Modifier.align(
                            Alignment.TopEnd
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vector_3),
                        contentDescription = "",
                        modifier = Modifier.align(
                            Alignment.BottomEnd
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vector_4),
                        contentDescription = "",
                        modifier = Modifier.align(
                            Alignment.BottomStart
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterEnd),
                ) {
                    ModelSelector(
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White)
                            .padding(5.dp),
                        onClick = {
                            currentModel.value = it
                        })
                }


                this@Column.AnimatedVisibility(visible = showInstructions) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color(0xFF393939))
                            .padding(16.dp)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_view_in_ar_new_googblue_48dp),
                            contentDescription = "image description",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Please scan the room by\nmoving your phone around",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(600),
                                color = Color.White,
                                letterSpacing = 0.06.sp,
                            )
                        )
                    }
                }
            }


        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
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
                        color = Color.White,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
                    .clickable { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "image description", modifier = Modifier.alpha(0f)
                )
                Text(
                    text = "Back",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.07.sp,
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFF828282),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
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
                    imageVector = Icons.Filled.ShoppingCart,
                    tint = Color.White,
                    contentDescription = "image description"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Add to cart",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.06.sp,
                    )
                )
            }


        }

    }


}

@Composable
fun ARScreen(model: String) {

    val nodes = remember {
        mutableListOf<ArNode>()
    }
    var engine by remember {
        mutableStateOf<Engine?>(null)
    }

    val modelNode = remember {
        mutableStateOf<ArModelNode?>(null)
    }



    Box(modifier = Modifier.fillMaxSize()) {
        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = nodes,
            planeRenderer = true,
            onCreate = { arSceneView ->
                arSceneView.lightEstimationMode = Config.LightEstimationMode.DISABLED
                arSceneView.planeRenderer.isShadowReceiver = false
                arSceneView.depthEnabled = true
                engine = arSceneView.engine
                engine?.let {
                    val arModelNode = ArModelNode(it, PlacementMode.INSTANT).apply {
                        loadModelGlbAsync(
                            glbFileLocation = "models/${model}.glb",
                            scaleToUnits = 0.8f
                        ) {

                        }
                    }

                    modelNode.value = arModelNode
                    nodes.add(arModelNode)

                }
            },
            onSessionCreate = {
                planeRenderer.isVisible = false
            }
        )
    }

    LaunchedEffect(key1 = model) {

        if (modelNode.value?.isAnchored == false)
            modelNode.value?.loadModelGlbAsync(
                glbFileLocation = "models/${model}.glb",
                scaleToUnits = scaleToUnits
            )


        if (modelNode.value?.isAnchored == true || modelNode.value == null)
            engine?.let {
                val arModelNode = ArModelNode(it, PlacementMode.INSTANT).apply {
                    loadModelGlbAsync(
                        glbFileLocation = "models/${model}.glb",
                        scaleToUnits = scaleToUnits
                    ) {

                    }

                }

                modelNode.value = arModelNode
                nodes.add(arModelNode)
            }
        modelNode.value?.anchor()
    }

}


@Composable
fun ModelSelector(modifier: Modifier = Modifier, onClick: (String) -> Unit) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(2.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(models) {
            ModelView(modifier = Modifier.clickable { onClick(it.name) }, imageId = it.imageId)
        }

    }
}

@Composable
fun ModelView(
    modifier: Modifier = Modifier,
    imageId: Int
) {
    Box(
        modifier = modifier
            .size(35.dp)
            .clip(RoundedCornerShape(5.dp))

    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}
