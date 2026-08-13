package Freeflix.service;

import Freeflix.model.Movie;
import Freeflix.model.WatchHistory;
import Freeflix.repo.MovieRepository;
import Freeflix.repo.WatchHistoryRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

  private final WatchHistoryRepository historyRepo;
  private final MovieRepository movieRepo;

  public RecommendationService(WatchHistoryRepository historyRepo, MovieRepository movieRepo) {
    this.historyRepo = historyRepo;
    this.movieRepo = movieRepo;
  }

  // Simple content-based: recommend by genres watched most
  public List<Movie> recommendForUser(String userId, int limit) {
    var histories = historyRepo.findByUserId(userId);
    Map<String, Long> genreCounts = new HashMap<>();

    for (WatchHistory h : histories) {
      var movie = movieRepo.findById(h.getMovieId()).orElse(null);
      if (movie != null && movie.getGenres() != null) {
        for (String g : movie.getGenres()) {
          genreCounts.put(g, genreCounts.getOrDefault(g, 0L) + 1);
        }
      }
    }

    List<String> topGenres = genreCounts.entrySet().stream()
      .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
      .map(Map.Entry::getKey)
      .limit(3)
      .collect(Collectors.toList());

    if (topGenres.isEmpty()) {
      return movieRepo.findTop10ByOrderByReleaseDateDesc().stream().limit(limit).collect(Collectors.toList());
    }
    return movieRepo.findByGenresIn(topGenres).stream().limit(limit).collect(Collectors.toList());
  }
}