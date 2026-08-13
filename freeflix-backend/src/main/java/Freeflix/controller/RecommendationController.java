package Freeflix.controller;


import Freeflix.model.Movie;
import Freeflix.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

  private final RecommendationService recommendationService;

  public RecommendationController(RecommendationService recommendationService) {
    this.recommendationService = recommendationService;
  }

  @GetMapping("/{userId}")
  public List<Movie> recommend(@PathVariable String userId, @RequestParam(defaultValue = "10") int limit) {
    return recommendationService.recommendForUser(userId, limit);
  }
}