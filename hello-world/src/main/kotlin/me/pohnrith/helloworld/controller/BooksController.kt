package me.pohnrith.helloworld.controller

import me.pohnrith.helloworld.controller.response.BookRes
import me.pohnrith.helloworld.controller.response.MessageRes
import me.pohnrith.helloworld.model.Book
import me.pohnrith.helloworld.service.BookService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/books")
class BooksController(
    private val booksService: BookService
){
    private val log = LoggerFactory.getLogger(this::class.java)


    @GetMapping
    fun listAllBooks(
        @RequestParam author: String,
        @RequestParam title: String,
        @RequestParam price: BigDecimal,
        @RequestParam priceFrom: BigDecimal?,
        @RequestParam priceTo: BigDecimal?
    ) : List<BookRes> {
        log.info("User Request This Endpoint[/api/v1/books] with Param Author[$author] and Param Title[$title]")
        return booksService.listAll(author, title, price, priceFrom, priceTo)

    }

    @GetMapping("/{id}")
    fun getBookDetail(@PathVariable id: Long) : Any {
        return booksService.getBookDetail(id)
    }

    @PostMapping
    fun createBook(@RequestBody book: Book) : MessageRes {
        return booksService.createNewBook(book)
    }

    @PutMapping
    fun updateBook(@RequestBody book: Book) : MessageRes {
        return booksService.updateBook(book)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) : MessageRes {
        return booksService.deleteBook(id)
    }
}