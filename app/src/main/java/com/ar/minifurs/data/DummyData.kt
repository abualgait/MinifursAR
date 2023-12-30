package com.ar.minifurs.data

import com.ar.minifurs.R

val productsCategories = listOf(
    Product(0, R.drawable.star, "Popular", "", 0),
    Product(1, R.drawable.wooden_chair, "Chair", "", 0),
    Product(2, R.drawable.standing_table, "Workstation", "", 0),
    Product(3, R.drawable.sofa, "Living room", "", 0),
    Product(4, R.drawable.bed, "Bedroom", "", 0),
    Product(1, R.drawable.wooden_chair, "Chair", "", 0),
    Product(2, R.drawable.standing_table, "Workstation", "", 0),
    Product(3, R.drawable.sofa, "Living room", "", 0),
    Product(4, R.drawable.bed, "Bedroom", "", 0),
)

val products = listOf(
    Product(0, R.drawable.product_pic, "Sverom chair", "", 0, 10_000f),
    Product(1, R.drawable.product_pic_1, "Sverom chair", "", 0, 7_000f),
    Product(2, R.drawable.product_pic_2, "Sverom chair", "", 0, 5_000f),
    Product(3, R.drawable.product_pic_3, "Sverom chair", "", 0, 12_000f),
)

val models = listOf(
    ModelItem("double_bed", R.drawable.double_bed),
    ModelItem("three_seater_couch", R.drawable.three_seater_couch),
    ModelItem("wooden_arm_chair", R.drawable.wooden_arm_chair),
    ModelItem("standing_desk", R.drawable.standing_desk),
    ModelItem("coffee_cup", R.drawable.coffee_cup)
)

data class ModelItem(var name: String, var imageId: Int)