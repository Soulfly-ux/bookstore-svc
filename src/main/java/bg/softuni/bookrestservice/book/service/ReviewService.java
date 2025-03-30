package bg.softuni.bookrestservice.book.service;

import bg.softuni.bookrestservice.book.model.Review;
import bg.softuni.bookrestservice.book.repository.ReviewRepository;
import bg.softuni.bookrestservice.exception.ReviewNotFoundException;
import bg.softuni.bookrestservice.web.dto.NewReviewRequest;
import bg.softuni.bookrestservice.web.dto.ReviewResponse;
import bg.softuni.bookrestservice.web.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewResponse> getReviewsByBookId(UUID bookId) {
        return reviewRepository.findByBookId(bookId)
                .stream()
                .map(DtoMapper::toReviewResponse)
                .toList();
  }

    public Review createReview(NewReviewRequest newReviewRequest) {

        if (newReviewRequest == null) {
            throw new IllegalArgumentException("New review request cannot be null");
        }
        System.out.println("NewReviewRequest: " + newReviewRequest);


        Review review = Review.builder()
                .id(UUID.randomUUID())
                .bookId(newReviewRequest.getBookId())
                .userId(newReviewRequest.getUserId())
                .comment(newReviewRequest.getComment())
                .rating(newReviewRequest.getRating())
                .createdAt(LocalDateTime.now())
                .build();

        System.out.println("Review before save: " + review);

        return reviewRepository.save(review);
    }

    public List<ReviewResponse> getReviewsByUserId(UUID userId) {

        return reviewRepository.findByUserId(userId).stream().map(DtoMapper::toReviewResponse).toList();
    }

    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(DtoMapper::toReviewResponse)
                .toList();
    }

    public Double getAverageRatingByBookId(UUID bookId) throws ReviewNotFoundException {

        List<Review> reviews = reviewRepository.findByBookId(bookId);
        if(reviews.isEmpty()) {
            throw new ReviewNotFoundException("No reviews found for book with id: " + bookId);
        }
        return reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }


//
//    public List<Review> getAllBooks() {
//
//        return bookRepository.findAll(); }
//
//
//    public Optional<Review> getById(UUID id) {
//
//        return bookRepository.findById(id);
//    }
//
//    public Review createBook(NewBookRequest newBookRequest) {
//
//        Review book = Review.builder()
//                .title(newBookRequest.getTitle())
//                .author(newBookRequest.getAuthor())
//                .price(newBookRequest.getPrice())
//                .build();
//
//        return bookRepository.save(book);
//    }
//
//    public Review saveBook(Review book) {
//
//        return bookRepository.save(book);
//    }
}
