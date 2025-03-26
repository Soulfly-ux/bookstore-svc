package bg.softuni.bookrestservice.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ReviewResponse {

    private UUID bookId;

    private UUID userId;

    private String comment;

    private int rating;

    private LocalDateTime createdAt;

}
