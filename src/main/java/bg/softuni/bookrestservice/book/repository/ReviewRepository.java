package bg.softuni.bookrestservice.book.repository;

import bg.softuni.bookrestservice.book.model.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByBookId(UUID bookId);

    List<Review> findByUserId(UUID userId);
}
