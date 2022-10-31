package me.pohnrith.helloworld.controller.response

import me.pohnrith.helloworld.model.Book
import java.math.BigDecimal

data class BookRes(
    val id: Long,
    val title: String,
    val author: String,
    val price: BigDecimal
)