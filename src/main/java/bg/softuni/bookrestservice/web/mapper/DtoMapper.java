package bg.softuni.bookrestservice.web.mapper;

import bg.softuni.bookrestservice.book.model.Book;
import bg.softuni.bookrestservice.web.dto.BookResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {

    public static BookResponse toBookResponse(Book book) {

        return BookResponse
                .builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .build();
    }
}
