package bg.softuni.bookrestservice.web;

import bg.softuni.bookrestservice.book.service.ReviewNotFoundException;
import bg.softuni.bookrestservice.book.service.ReviewService;

import bg.softuni.bookrestservice.web.dto.NewReviewRequest;
import bg.softuni.bookrestservice.web.dto.ReviewResponse;
import bg.softuni.bookrestservice.web.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {


    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByBookId(@PathVariable UUID bookId) {

       return ResponseEntity.ok(reviewService.getReviewsByBookId(bookId));

   }

   @PostMapping
    public ResponseEntity<ReviewResponse> createReview(@RequestBody NewReviewRequest newReviewRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(DtoMapper.toReviewResponse(reviewService.createReview(newReviewRequest)));

   }

   @GetMapping("/user/{userId}")
   public ResponseEntity<List<ReviewResponse>> getReviewsByUserId(@PathVariable UUID userId) {
       return ResponseEntity.ok(reviewService.getReviewsByUserId(userId));

   }

   @GetMapping("/{bookId}/average-rating")
    public ResponseEntity<Double> getAverageRatingByBookId(@PathVariable UUID bookId) throws ReviewNotFoundException {
        return ResponseEntity.ok(reviewService.getAverageRatingByBookId(bookId));
   }




//
//
//    @GetMapping
//    public List<BookResponse> getAllBooks() {
//
//        return bookService.getAllBooks().stream().map(DtoMapper::toBookResponse).toList();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Review> getBookById(@PathVariable UUID id) {
//
//        return null;
//    }
//
//    @PostMapping
//    public ResponseEntity<BookResponse> createBook(@RequestBody NewBookRequest newBookRequest) {
//
//        Review book = bookService.createBook(newBookRequest);
//
//        BookResponse bookResponse = DtoMapper.toBookResponse(book);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .header("book-service", "Spring Boot Project")
//                .body(bookResponse);
//    }
//
    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam String name) {

        return ResponseEntity.ok("Hello " + name + " from Book Service");
    }
}
