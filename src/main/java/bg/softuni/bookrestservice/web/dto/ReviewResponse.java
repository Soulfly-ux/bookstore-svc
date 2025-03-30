package bg.softuni.bookrestservice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ReviewResponse {


    @NotBlank
    private String comment;

    @Min(1) @Max(5)
    private Integer rating;

    @CreatedDate
    private LocalDateTime createdAt;



}
