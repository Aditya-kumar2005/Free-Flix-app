package Freeflix.service;

import Freeflix.model.Movie;
import Freeflix.repo.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
  private final MovieRepository movieRepo;

  public MovieService(MovieRepository movieRepo) {
    this.movieRepo = movieRepo;
  }

  public List<Movie> latest() {
    return movieRepo.findTop10ByOrderByReleaseDateDesc();
  }

  public Movie get(String id) {
    return movieRepo.findById(id).orElseThrow();
  }

  public Movie save(Movie m) {
    return movieRepo.save(m);
  }

  public void incrementViews(String id) {
    var m = get(id);
    m.setViews(m.getViews() + 1);
    movieRepo.save(m);
  }

  public void updateAverageRating(String movieId, double avg) {
    var m = get(movieId);
    m.setAverageRating(avg);
    movieRepo.save(m);
  }
}
