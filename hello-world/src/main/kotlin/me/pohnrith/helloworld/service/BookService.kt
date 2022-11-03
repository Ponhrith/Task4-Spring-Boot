package me.pohnrith.helloworld.service

import me.pohnrith.helloworld.controller.response.BookRes
import me.pohnrith.helloworld.controller.response.MessageRes
import me.pohnrith.helloworld.model.Book
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal

@Service
class BookService {

    private val books = mutableListOf<Book>(
        Book(1, "Book A", "A Author", BigDecimal(100), BigDecimal(90)),
        Book(2, "Book B", "B Author", BigDecimal(89), BigDecimal(60))
    )


    fun listAll(author: String?, title: String?, price: BigDecimal?, priceFrom: BigDecimal?, priceTo: BigDecimal?) : List<BookRes> {

        var result = books.toList()
        author?.let { authorQuery ->
            result = result.filter { it.author.contains(authorQuery, ignoreCase = true) }
        }
        title?.let {titleQuery ->
            result = result.filter { it.title.contains(titleQuery, ignoreCase = true) }
        }
        priceFrom?.let {priceFromQuery->
            result = result.filter {it.price >= (priceFromQuery)}
        }
        priceTo?.let{priceToQuery->
            result = result.filter {it.price <= (priceToQuery)}
        }
        return result.map { it.convertToBookRes() }


    }

    fun getBookDetail(id: Long) : Any {
        val book = books.firstOrNull { it.id == id }
        return book?.convertToBookRes() ?: MessageRes("BookID[${id}] is not existed.")
    }

    fun createNewBook(book: Book) : MessageRes {
        if (books.firstOrNull {it.id == book.id} != null) {
            return MessageRes("BookID[${book.id}] is already existed.")
        }
        books.add(book)
        return MessageRes("BookID[${book.id}] is inserted to database successfully.")
    }

    fun updateBook(book: Book) : MessageRes {
        if (books.firstOrNull {it.id == book.id} == null) {
            return MessageRes("BookID[${book.id}] is not existed.")
        }
        books.removeIf { it.id == book.id }
        books.add(book)
        return MessageRes("BookID[${book.id}] is updated successfully.")
    }

    fun deleteBook(id: Long) : MessageRes {
        if (books.firstOrNull {it.id == id} == null) {
            return MessageRes("BookID[${id}] is not existed.")
        }
        books.removeIf { it.id == id }
        return MessageRes("BookID[${id}] is deleted successfully.")
    }

}