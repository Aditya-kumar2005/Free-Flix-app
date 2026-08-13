package Freeflix.controller;


import Freeflix.model.Movie;
import Freeflix.service.MovieService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/latest")
  public List<Movie> latest() {
    return movieService.latest();
  }

  @GetMapping("/{id}")
  public Movie get(@PathVariable String id) {
    return movieService.get(id);
  }

  @PostMapping("/admin")
  public Movie create(@RequestBody Movie movie) {
    // Admin-only in production; simplified here
    return movieService.save(movie);
  }
}