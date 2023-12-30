package com.ar.minifurs.ui.motionscene

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionScene

enum class ViewRef {
    Title,
    SearchBar,
    Image,
    Overlay,
    RoundShape
}

@Composable
fun dashboardMotionScene(): MotionScene {
    return MotionScene {
        val image = createRefFor(ViewRef.Image.name)
        val roundShape = createRefFor(ViewRef.RoundShape.name)
        val overlay = createRefFor(ViewRef.Overlay.name)
        val title = createRefFor(ViewRef.Title.name)
        val searchBar = createRefFor(ViewRef.SearchBar.name)

        val initialConstraintSet = constraintSet {
            constrain(image) {
                width = Dimension.matchParent
                height = Dimension.matchParent
            }

            constrain(roundShape) {
                width = Dimension.matchParent
                height = Dimension.preferredValue(30.dp)
                bottom.linkTo(parent.bottom)

            }

            constrain(overlay) {
                width = Dimension.matchParent
                height = Dimension.matchParent
            }
            constrain(title) {
                centerTo(parent)
                alpha = 1f
                scaleX = 1f
                scaleY = 1f
                customFontSize("textSize", 20.sp)
            }
            constrain(searchBar) {
                width = Dimension.percent(0.8f)
                centerHorizontallyTo(parent)
                top.linkTo(title.bottom, 16.dp)
            }
        }
        val finalConstraintSet = constraintSet {

            constrain(roundShape) {
                width = Dimension.matchParent
                height = Dimension.preferredValue(30.dp)
                bottom.linkTo(parent.bottom)

            }
            constrain(image) {
                width = Dimension.matchParent
                height = Dimension.matchParent
            }
            constrain(overlay) {
                width = Dimension.matchParent
                height = Dimension.matchParent
            }
            constrain(title) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top, 50.dp)
                alpha = 1f
                scaleX = 1f
                scaleY = 1f
                customFontSize("textSize", 12.sp)
            }
            constrain(searchBar) {
                width = Dimension.percent(0.9f)
                start.linkTo(title.start)
                top.linkTo(title.bottom, 16.dp)
            }
        }
        defaultTransition(
            from = initialConstraintSet,
            to = finalConstraintSet
        )
    }
}
