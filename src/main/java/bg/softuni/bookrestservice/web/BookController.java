package bg.softuni.bookrestservice.web;

import bg.softuni.bookrestservice.book.model.Book;
import bg.softuni.bookrestservice.book.service.BookService;
import java.util.List;
import java.util.UUID;

import bg.softuni.bookrestservice.web.dto.BookResponse;
import bg.softuni.bookrestservice.web.dto.NewBookRequest;
import bg.softuni.bookrestservice.web.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static bg.softuni.bookrestservice.web.Paths.API_V1_PATH;

@RestController
@RequestMapping(API_V1_PATH + "/books")
public class BookController {


    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {

        return bookService.getAllBooks().stream().map(DtoMapper::toBookResponse).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id) {

        return null;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody NewBookRequest newBookRequest) {

        Book book = bookService.createBook(newBookRequest);

        BookResponse bookResponse = DtoMapper.toBookResponse(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("book-rest-service", "Spring Boot Project")
                .body(bookResponse);
    }
}
