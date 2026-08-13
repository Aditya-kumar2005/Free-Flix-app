package Freeflix.controller;

import Freeflix.model.Review;
import Freeflix.repo.ReviewRepository;
import Freeflix.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  private final ReviewRepository reviewRepo;
  private final MovieService movieService;

  public ReviewController(ReviewRepository reviewRepo, MovieService movieService) {
    this.reviewRepo = reviewRepo;
    this.movieService = movieService;
  }

  @GetMapping("/movie/{movieId}")
  public List<Review> forMovie(@PathVariable String movieId) {
    return reviewRepo.findByMovieId(movieId);
  }

  @PostMapping("/movie/{movieId}")
  public Review add(@PathVariable String movieId, @RequestBody Review review) {
    review.setMovieId(movieId);
    review.setCreatedAt(Instant.now());
    var saved = reviewRepo.save(review);

    // update average rating
    var all = reviewRepo.findByMovieId(movieId);
    double avg = all.stream().mapToInt(Review::getRating).average().orElse(0.0);
    movieService.updateAverageRating(movieId, avg);

    return saved;
  }
}