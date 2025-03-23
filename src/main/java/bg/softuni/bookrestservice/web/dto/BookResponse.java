package bg.softuni.bookrestservice.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {

    private String title;
    private String author;
    private double price;
}
