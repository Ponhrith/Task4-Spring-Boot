package me.pohnrith.helloworld.model

import me.pohnrith.helloworld.controller.response.BookRes
import java.math.BigDecimal

data class Book(
    val id: Long,
    val title: String,
    val author: String,
    val price: BigDecimal,
    val costPrice: BigDecimal,

){
    fun convertToBookRes() : BookRes {
        return BookRes(id = id, title = title, author = author, price = price)
    }
}
