package Freeflix.controller;


import Freeflix.model.Movie;
import Freeflix.service.AdService;
import Freeflix.service.MovieService;
import Freeflix.service.StreamingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/stream")
public class StreamingController {

  private final MovieService movieService;
  private final StreamingService streamingService;
  private final AdService adService;

  public StreamingController(MovieService movieService, StreamingService streamingService, AdService adService) {
    this.movieService = movieService;
    this.streamingService = streamingService;
    this.adService = adService;
  }

  @GetMapping("/{movieId}/session")
  public Map<String, Object> startSession(@PathVariable String movieId) {
    Movie movie = movieService.get(movieId);
    movieService.incrementViews(movieId);

    var preroll = adService.preroll();
    var midrolls = adService.midrolls();
    var postroll = adService.postroll();

    return Map.of(
      "moviePlaylist", streamingService.getPlaylist(movie),
      "preroll", preroll != null ? preroll.getAdVideoHlsUrl() : null,
      "midrolls", midrolls.stream().map(m -> m.getAdVideoHlsUrl()).toList(),
      "postroll", postroll != null ? postroll.getAdVideoHlsUrl() : null
    );
  }
}
