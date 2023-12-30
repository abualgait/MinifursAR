package com.ar.minifurs.data

data class Product(
    val id: Int,
    val image: Int,
    var title: String,
    var describtion: String,
    var qty: Int,
    var price:Float = 0f
)