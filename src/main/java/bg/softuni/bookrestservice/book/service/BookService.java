package bg.softuni.bookrestservice.book.service;

import bg.softuni.bookrestservice.book.model.Book;
import bg.softuni.bookrestservice.book.repository.BookRepository;
import bg.softuni.bookrestservice.web.dto.BookResponse;
import bg.softuni.bookrestservice.web.dto.NewBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {

        return bookRepository.findAll(); }


    public Optional<Book> getById(UUID id) {

        return bookRepository.findById(id);
    }

    public Book createBook(NewBookRequest newBookRequest) {

        Book book = Book.builder()
                .title(newBookRequest.getTitle())
                .author(newBookRequest.getAuthor())
                .price(newBookRequest.getPrice())
                .build();

        return bookRepository.save(book);
    }

    public Book saveBook(Book book) {

        return bookRepository.save(book);
    }
}
