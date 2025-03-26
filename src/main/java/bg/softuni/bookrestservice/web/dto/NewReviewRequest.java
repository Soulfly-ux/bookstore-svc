package bg.softuni.bookrestservice.web.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NewReviewRequest {

    private UUID bookId;

    private UUID userId;

    private String comment;

    private int rating;

    private LocalDateTime createdAt;


}
