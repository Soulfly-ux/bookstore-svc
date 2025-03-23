package bg.softuni.bookrestservice.web.dto;

import lombok.Data;

@Data
public class NewBookRequest {

    private String title;
    private String author;
    private double price;

}
