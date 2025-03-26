package bg.softuni.bookrestservice.web.mapper;

import bg.softuni.bookrestservice.book.model.Review;
import bg.softuni.bookrestservice.web.dto.ReviewResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class DtoMapper {

    public static ReviewResponse toReviewResponse(Review review) {

        return ReviewResponse.builder()
                .bookId(review.getBookId())
                .userId(review.getUserId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
